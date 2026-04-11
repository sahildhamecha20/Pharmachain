package Pharmachain.controller;

import Pharmachain.Dto.BillRequest;
import Pharmachain.entity.SalesLedger;
import Pharmachain.service.impl.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/process")
    public ResponseEntity<SalesLedger> createBill(@RequestBody BillRequest request) {
        SalesLedger savedBill = billingService.processSale(request.getItems(), request.getCustomerName(), request.getBillType());
        return ResponseEntity.ok(savedBill);
    }
}