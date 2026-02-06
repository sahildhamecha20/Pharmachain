package Pharmachain.entity;

import Pharmachain.repository.InventoryBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ExpiryAlertJob {

    @Autowired
    private InventoryBatchRepository batchRepo;

    // Runs daily at 9 AM
    @Scheduled(cron = "0 0 9 * * ?")
    public void checkExpiringBatches() {

        LocalDate limit = LocalDate.now().plusDays(30);

        List<InventoryBatch> expiring =
                batchRepo.findByExpiryDateBefore(limit);

        expiring.forEach(b ->
                System.out.println("⚠ EXPIRING: " +
                        "Batch: " + b.getBatchNo() +
                        " | Expiry: " + b.getExpiryDate())
        );
    }
}