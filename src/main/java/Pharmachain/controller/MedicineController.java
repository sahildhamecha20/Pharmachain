package Pharmachain.controller;

import Pharmachain.entity.Medicine;
import Pharmachain.service.impl.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add")
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    @GetMapping("/all")
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }

    @PutMapping("/update/{id}")
    public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        return medicineService.updateMedicine(id, medicine);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return "Medicine deleted successfully";
    }

    @GetMapping("/expired")
    public List<Medicine> expiredMedicines() {
        return medicineService.getExpiredMedicines();
    }

    @GetMapping("/expiring-soon")
    public List<Medicine> expiringSoon() {
        return medicineService.getExpiringSoonMedicines();
    }
}