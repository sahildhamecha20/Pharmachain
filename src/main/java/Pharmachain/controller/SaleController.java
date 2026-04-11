package Pharmachain.controller;

import Pharmachain.Dto.SaleRequestDTO;
import Pharmachain.entity.Sale;
import Pharmachain.service.impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin("*")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/process")
    public ResponseEntity<?> createSale(@RequestBody SaleRequestDTO request) {
        try {
            return ResponseEntity.ok(saleService.processSale(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<Sale>> getHistory() {
        return ResponseEntity.ok(saleService.getSaleHistory());
    }
}