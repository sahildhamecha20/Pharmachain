package Pharmachain.controller;

import Pharmachain.entity.InventoryBatch;

import Pharmachain.service.impl.InventoryBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin("*")
public class InventoryBatchController {

    @Autowired
    private InventoryBatchService service;

    @PostMapping("/save")
    public ResponseEntity<InventoryBatch> addBatch(@RequestBody InventoryBatch batch) {
        return ResponseEntity.ok(service.saveBatch(batch));
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryBatch>> getAll() {
        return ResponseEntity.ok(service.getAllBatches());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteBatch(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}