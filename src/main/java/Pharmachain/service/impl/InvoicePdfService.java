package Pharmachain.service.impl;

import Pharmachain.dto.InvoiceDataDto;
import Pharmachain.dto.InvoiceItemDto;
import Pharmachain.entity.InventoryBatch;
import Pharmachain.repository.InventoryBatchRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;

@Service
public class InvoicePdfService {

    @Autowired
    private InventoryBatchRepository inventoryRepository;

    @Transactional
    public byte[] generateInvoicePdf(InvoiceDataDto invoice) throws Exception {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, out);
        writer.setPageEvent(new PdfEventHelper());

        document.open();

        // Fonts configuration
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.DARK_GRAY);
        Font bold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
        Font normal = new Font(Font.FontFamily.HELVETICA, 10);

        // 1. Header
        String dynamicShopName = (invoice.getPharmacyName() != null && !invoice.getPharmacyName().isEmpty())
                ? invoice.getPharmacyName() : "Shree Medical Store";

        Paragraph shopHeader = new Paragraph(dynamicShopName, titleFont);
        shopHeader.setAlignment(Element.ALIGN_CENTER);
        document.add(shopHeader);
        document.add(Chunk.NEWLINE);

        // 2. Invoice Details
        document.add(new Paragraph("Invoice No: " + (invoice.getInvoiceNumber() != null ? invoice.getInvoiceNumber() : "PH-INV-001"), normal));
        document.add(new Paragraph("Customer: " + (invoice.getCustomerName() != null ? invoice.getCustomerName() : "Walking Customer"), normal));
        if(invoice.getCustomerMobile() != null) {
            document.add(new Paragraph("Mobile: +91 " + invoice.getCustomerMobile(), normal));
        }
        document.add(Chunk.NEWLINE);

        // 3. Table setup
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3f, 1.5f, 1.5f, 1f, 1.5f, 1.5f});

        String[] headers = {"Medicine/Item", "Batch", "Expiry", "Qty", "Price", "Amount"};
        for (String h : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(h, bold));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5);
            table.addCell(cell);
        }

        // 4. Adding Items AND Updating Stock logic
        if (invoice.getItems() != null) {
            for (InvoiceItemDto item : invoice.getItems()) {

                inventoryRepository.findByMedicineNameAndBatchId(item.getMedicineName(), item.getBatchNo())
                        .ifPresent(inventoryItem -> {
                            int currentStock = inventoryItem.getQuantity();
                            int billingQty = (int) item.getQuantity();
                            if (currentStock >= billingQty) {
                                inventoryItem.setQuantity(currentStock - billingQty);
                                inventoryRepository.save(inventoryItem);
                            }
                        });
                // --- STOCK UPDATE LOGIC END ---

                double amount = item.getQuantity() * item.getPrice();
                table.addCell(new Phrase(item.getMedicineName(), normal));
                table.addCell(new Phrase(item.getBatchNo() != null ? item.getBatchNo() : "-", normal));
                table.addCell(new Phrase(item.getExpiryDate() != null ? item.getExpiryDate() : "-", normal));
                table.addCell(new Phrase(String.valueOf(item.getQuantity()), normal));
                table.addCell(new Phrase(String.format("%.2f", item.getPrice()), normal));
                table.addCell(new Phrase(String.format("%.2f", amount), normal));
            }
        }

        document.add(table);
        document.add(Chunk.NEWLINE);

        // 5. Totals
        Paragraph totals = new Paragraph();
        totals.add(new Chunk("Sub Total: ₹" + String.format("%.2f", invoice.getSubTotal()) + "\n", normal));
        totals.add(new Chunk("GST: ₹" + String.format("%.2f", invoice.getGstAmount()) + "\n", normal));
        totals.add(new Chunk("Grand Total: ₹" + String.format("%.2f", invoice.getGrandTotal()), bold));
        totals.setAlignment(Element.ALIGN_RIGHT);
        document.add(totals);

        document.close();
        return out.toByteArray();
    }

    class PdfEventHelper extends PdfPageEventHelper {
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContentUnder();
            Font watermarkFont = new Font(Font.FontFamily.HELVETICA, 60, Font.BOLD, new BaseColor(200, 200, 200, 40));
            Phrase watermark = new Phrase("PHARMACHAIN", watermarkFont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, watermark, 297, 421, 45);

            Font footerFont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC, BaseColor.GRAY);
            Phrase footer = new Phrase("Powered by PharmaChain - Secure Pharmaceutical Management", footerFont);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, footer, 297, 20, 0);
        }
    }
}