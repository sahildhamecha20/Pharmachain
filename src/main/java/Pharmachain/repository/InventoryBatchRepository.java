package Pharmachain.repository;

import Pharmachain.entity.InventoryBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryBatchRepository extends JpaRepository<InventoryBatch, Long> {


    List<InventoryBatch> findByExpiryDateBefore(LocalDate date);
    List<InventoryBatch> findByExpiryDateGreaterThanEqualAndActiveTrue(LocalDate date);
    List<InventoryBatch> findByActiveTrue();
    Optional<InventoryBatch> findByMedicineNameAndBatchNo(String medicineName, String batchNo);
}