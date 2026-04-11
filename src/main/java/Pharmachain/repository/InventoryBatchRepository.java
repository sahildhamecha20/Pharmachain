package Pharmachain.repository;

import Pharmachain.entity.InventoryBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryBatchRepository extends JpaRepository<InventoryBatch, Long> {

    List<InventoryBatch> findByActiveTrue();
    Optional<InventoryBatch> findByMedicineName(String medicineName);
}