package Pharmachain.controller;

import Pharmachain.dto.InventoryBatchRequestDto;
import Pharmachain.dto.InventoryBatchResponseDto;
import Pharmachain.service.impl.InventoryBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory/batch")
@CrossOrigin
public class InventoryBatchController {

    @Autowired
    private InventoryBatchService service;

    // Standard POST method for adding batch
    @PostMapping
    public InventoryBatchResponseDto addBatch(@RequestBody InventoryBatchRequestDto request) {
        return service.addBatch(request);
    }


    @GetMapping("/expiry-alerts")
    public ResponseEntity<List<InventoryBatchResponseDto>> getExpiryAlerts() {
        return ResponseEntity.ok(service.getExpiryAlerts());
    }

    @PostMapping("/add")
    public ResponseEntity<InventoryBatchResponseDto> addBatchExplicit(@RequestBody InventoryBatchRequestDto dto){
        return ResponseEntity.ok(service.addBatch(dto));
    }

    @GetMapping("/{id}")
    public InventoryBatchResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public Page<InventoryBatchResponseDto> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/active")
    public List<InventoryBatchResponseDto> activeBatches() {
        return service.getActiveBatches();
    }

    @GetMapping("/low-stock")
    public List<InventoryBatchResponseDto> lowStock(
            @RequestParam(defaultValue = "10") Integer threshold) {
        return service.getLowStock(threshold);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateBatch(@PathVariable Long id) {
        service.deactivateBatch(id);
    }
}