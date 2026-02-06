package Pharmachain.service.impl;

import Pharmachain.dto.SaleRequestDto;
import Pharmachain.entity.Sale;
import Pharmachain.entity.InventoryBatch;
import Pharmachain.repository.SaleRepository;
import Pharmachain.repository.InventoryBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepo;

    @Autowired
    private InventoryBatchRepository inventoryRepo;

    @Override
    @Transactional
    public Sale createBill(SaleRequestDto request) {
        InventoryBatch batch = inventoryRepo.findByMedicineNameAndBatchNo(
                        request.getMedicineName(), request.getBatchNo())
                .orElseThrow(() -> new RuntimeException("Medicine/Batch not found!"));

        if (batch.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock!");
        }

        batch.setQuantity(batch.getQuantity() - request.getQuantity());
        inventoryRepo.save(batch);

        double totalAmount = batch.getSellingPrice() * request.getQuantity();
        double myCut = (totalAmount * 2.5) / 100;

        Sale sale = new Sale();
        sale.setTotalBillAmount(totalAmount);
        sale.setCommissionEarned(myCut);

        return saleRepo.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }
}