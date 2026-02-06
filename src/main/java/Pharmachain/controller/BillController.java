package Pharmachain.controller;

import Pharmachain.dto.BillRequestDto;

import Pharmachain.service.impl.BillPdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    private final BillPdfService billPdfService;

    public BillController(BillPdfService billPdfService) {
        this.billPdfService = billPdfService;
    }

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateBill(@RequestBody BillRequestDto bill) {
        byte[] pdf = billPdfService.generateBillPdf(bill);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bill.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}