package Pharmachain.Scheduler;

import Pharmachain.entity.InventoryBatch;
import Pharmachain.repository.InventoryBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ExpiryAlertScheduler {

    @Autowired
    private InventoryBatchRepository batchRepository;

    @Scheduled(cron = "0 0 9 * * ?") // daily 9 AM
    public void checkExpiry() {
        LocalDate alertDate = LocalDate.now().plusDays(30);
        List<InventoryBatch> batches =
                batchRepository.findByExpiryDateBefore(alertDate);

        batches.forEach(b ->
                System.out.println("⚠ EXPIRY ALERT: " + b.getBatchNo())
        );
    }
}