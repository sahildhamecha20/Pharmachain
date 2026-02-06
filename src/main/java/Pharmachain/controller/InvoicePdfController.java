package Pharmachain.controller;

import Pharmachain.dto.InvoiceDataDto;
import Pharmachain.service.impl.InvoicePdfService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")
public class InvoicePdfController {

    private final InvoicePdfService service;

    public InvoicePdfController(InvoicePdfService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generate(@RequestBody InvoiceDataDto dto) throws Exception {

        byte[] pdf = service.generateInvoicePdf(dto);

        return ResponseEntity.ok()
                .header("Content-Disposition", "inline; filename=invoice.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}