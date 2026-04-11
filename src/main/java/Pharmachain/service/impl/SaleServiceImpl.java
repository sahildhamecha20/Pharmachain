package Pharmachain.service.impl;

import Pharmachain.Dto.CartItemDTO;
import Pharmachain.Dto.SaleRequestDTO;
import Pharmachain.entity.InventoryBatch;
import Pharmachain.entity.Sale;
import Pharmachain.repository.InventoryBatchRepository;
import Pharmachain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private InventoryBatchRepository batchRepository;

    @Override
    @Transactional
    public Sale processSale(SaleRequestDTO request) {
        Sale sale = new Sale();
        sale.setInvoiceNumber("INV-" + System.currentTimeMillis());
        sale.setSaleDate(LocalDateTime.now());
        sale.setPaymentMode(request.getPaymentMode());

        double grandTotal = 0;

        for (CartItemDTO item : request.getItems()) {
            InventoryBatch batch = batchRepository.findById(item.getBatchId())
                    .orElseThrow(() -> new RuntimeException("Batch not found for ID: " + item.getBatchId()));

            if (batch.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Stock khatam for: " + batch.getMedicineName());
            }

            // Stock minus karo
            batch.setQuantity(batch.getQuantity() - item.getQuantity());
            batchRepository.save(batch);

            // Price add karo
            grandTotal += batch.getPrice() * item.getQuantity();
        }

        sale.setTotalBillAmount(grandTotal);
        return saleRepository.save(sale);
    }
    @Override
    public List<Sale> getSaleHistory() {
        return saleRepository.findAll();
    }
}