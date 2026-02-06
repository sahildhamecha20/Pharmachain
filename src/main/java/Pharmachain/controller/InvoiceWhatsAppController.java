package Pharmachain.controller;

import Pharmachain.dto.InvoiceDataDto;
import Pharmachain.service.impl.InvoicePdfService;

import Pharmachain.service.impl.WhatsAppService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp")
public class InvoiceWhatsAppController {

    private final InvoicePdfService invoicePdfService;
    private final WhatsAppService whatsAppService;

    public InvoiceWhatsAppController(InvoicePdfService invoicePdfService,
                                     WhatsAppService whatsAppService) {
        this.invoicePdfService = invoicePdfService;
        this.whatsAppService = whatsAppService;
    }

    @PostMapping("/send-invoice")
    public String sendInvoiceOnWhatsApp(@RequestBody InvoiceDataDto invoiceDto) throws Exception {

        byte[] pdfBytes = invoicePdfService.generateInvoicePdf(invoiceDto);
        whatsAppService.sendInvoicePdf(invoiceDto.getCustomerMobile(), pdfBytes);

        return "Invoice sent on WhatsApp successfully";
    }
}