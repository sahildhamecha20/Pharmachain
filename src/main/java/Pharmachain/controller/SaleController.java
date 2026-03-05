package Pharmachain.controller;

import Pharmachain.dto.SaleRequestDto;
import Pharmachain.entity.Sale;
import Pharmachain.service.impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class SaleController {

    @Autowired
    private SaleService saleService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> generateBill(@RequestBody SaleRequestDto request) {
        Sale savedSale = saleService.createBill(request);

        Map<String, Object> response = new HashMap<>();
        response.put("invoiceId", savedSale.getId());
        response.put("totalBill", savedSale.getTotalBillAmount());
        response.put("date", savedSale.getSaleDate());
        response.put("note", Sale.RETURN_POLICY);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/generate-bill")
    public ResponseEntity<Map<String, Object>> generateBillOld(@RequestBody SaleRequestDto request) {
        return generateBill(request);
    }
}