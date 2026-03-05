package Pharmachain.service.impl;

import Pharmachain.dto.InventoryBatchRequestDto;
import Pharmachain.dto.InventoryBatchResponseDto;
import Pharmachain.entity.InventoryBatch;
import Pharmachain.repository.InventoryBatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryBatchServiceImpl implements InventoryBatchService {

    @Autowired
    private InventoryBatchRepository repository;

    @Override
    public InventoryBatchResponseDto addBatch(InventoryBatchRequestDto request) {
        // 1. RequestDto se Entity mein data copy karo
        InventoryBatch batch = new InventoryBatch();
        BeanUtils.copyProperties(request, batch);

        // 2. Database mein save karo
        InventoryBatch savedBatch = repository.save(batch);

        return mapToResponseDto(savedBatch);
    }

    @Override
    public InventoryBatchResponseDto getById(Long id) {
        return null;
    }

    @Override
    public Page<InventoryBatchResponseDto> getAll(int page, int size) {
        return null;
    }

    @Override
    public List<InventoryBatchResponseDto> getActiveBatches() {
        return List.of();
    }

    @Override
    public List<InventoryBatchResponseDto> getLowStock(Integer threshold) {
        return List.of();
    }

    @Override
    public void deactivateBatch(Long id) {

    }

    @Override
    public List<InventoryBatchResponseDto> getExpiryAlerts() {
        LocalDate thresholdDate = LocalDate.now().plusDays(30);
        return repository.findByExpiryDateBefore(thresholdDate)
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Map Entity to ResponseDto
    private InventoryBatchResponseDto mapToResponseDto(InventoryBatch batch) {
        InventoryBatchResponseDto dto = new InventoryBatchResponseDto();
        BeanUtils.copyProperties(batch, dto);
        dto.setBatchId(batch.getBatchId());
        return dto;
    }
}