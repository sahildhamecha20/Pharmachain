package Pharmachain.controller;

import Pharmachain.entity.Purchase;
import Pharmachain.service.impl.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin("*")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/add")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.savePurchase(purchase));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> listAll() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @GetMapping("/today-total")
    public ResponseEntity<Double> getTodayTotal() {
        return ResponseEntity.ok(purchaseService.getTodayPurchase());
    }
}