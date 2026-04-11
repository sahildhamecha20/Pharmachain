package Pharmachain.controller;

import Pharmachain.entity.Medicine;
import Pharmachain.service.impl.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin("*")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add")
    public ResponseEntity<Medicine> add(@RequestBody Medicine medicine) {
        return ResponseEntity.ok(medicineService.saveMedicine(medicine));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Medicine>> getActive() {
        return ResponseEntity.ok(medicineService.getActiveMedicines());
    }

    @PutMapping("/update-stock/{id}")
    public ResponseEntity<String> updateStock(@PathVariable Long id, @RequestParam int qty) {
        medicineService.updateStock(id, qty);
        return ResponseEntity.ok("Stock updated successfully");
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.ok("Medicine deactivated");
    }
}