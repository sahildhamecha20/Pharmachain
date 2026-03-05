package Pharmachain.controller;

import Pharmachain.dto.InventoryBatchResponseDto;
import Pharmachain.service.impl.InventoryBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory/batch")
@CrossOrigin(origins = "*")
public class InventoryBatchController {

    @Autowired
    private InventoryBatchService service;

    @GetMapping
    public List<InventoryBatchResponseDto> getAll() {
        return service.getActiveBatches();
    }

    @GetMapping("/expiry-alerts")
    public List<InventoryBatchResponseDto> getExpiryAlerts() {
        return service.getExpiryAlerts();
    }

    @GetMapping("/low-stock")
    public List<InventoryBatchResponseDto> getLowStock(@RequestParam(defaultValue = "10") Integer threshold) {
        return service.getLowStock(threshold);
    }
}