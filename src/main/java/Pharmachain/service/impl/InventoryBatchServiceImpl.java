package Pharmachain.service.impl;

import Pharmachain.entity.InventoryBatch;
import Pharmachain.repository.InventoryBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryBatchServiceImpl implements InventoryBatchService {

    @Autowired
    private InventoryBatchRepository repository;

    @Override
    public InventoryBatch saveBatch(InventoryBatch batch) {
        return repository.save(batch);
    }

    @Override
    public List<InventoryBatch> getAllBatches() {
        return repository.findAll();
    }

    @Override
    public InventoryBatch getBatchById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteBatch(Long id) {
        repository.deleteById(id);
    }
}