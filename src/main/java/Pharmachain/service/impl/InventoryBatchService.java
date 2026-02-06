package Pharmachain.service.impl;

import Pharmachain.dto.InventoryBatchRequestDto;
import Pharmachain.dto.InventoryBatchResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryBatchService {

    InventoryBatchResponseDto addBatch(
            InventoryBatchRequestDto request);

    InventoryBatchResponseDto getById(Long id);

    Page<InventoryBatchResponseDto> getAll(
            int page, int size);

    List<InventoryBatchResponseDto> getActiveBatches();

    List<InventoryBatchResponseDto> getLowStock(
            Integer threshold);

    void deactivateBatch(Long id);

    List<InventoryBatchResponseDto> getExpiryAlerts();
}