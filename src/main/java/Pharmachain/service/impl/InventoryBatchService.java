package Pharmachain.service.impl;

import Pharmachain.entity.InventoryBatch;
import java.util.List;

public interface InventoryBatchService {
    InventoryBatch saveBatch(InventoryBatch batch);
    List<InventoryBatch> getAllBatches();
    InventoryBatch getBatchById(Long id);
    void deleteBatch(Long id);
}