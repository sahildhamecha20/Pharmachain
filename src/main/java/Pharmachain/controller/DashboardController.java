package Pharmachain.controller;

import Pharmachain.Dto.DashboardDTO;
import Pharmachain.repository.MedicineRepository;
import Pharmachain.repository.PurchaseRepository;
import Pharmachain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {
    @Autowired private MedicineRepository medRepo;
    @Autowired private SaleRepository saleRepo;
    @Autowired
    private PurchaseRepository purRepo;

    @GetMapping("/summary")
    public ResponseEntity<DashboardDTO> getSummary() {
        DashboardDTO dto = new DashboardDTO();
        dto.totalMedicines = medRepo.count();
        dto.todaySales = saleRepo.getTotalSalesToday();
        return ResponseEntity.ok(dto);
    }
}