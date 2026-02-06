package Pharmachain.controller;

import Pharmachain.entity.Medicine;
import Pharmachain.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/splash")
    public String splashPage() {
        return "splash";
    }

    // 2. Main Dashboard mapping
    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/bill")
    public String billingPage() {
        return "bill"; // templates/bill.html
    }

    // --- API Endpoints ---
    @GetMapping("/medicine/all")
    @ResponseBody
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @PostMapping("/medicine/add")
    @ResponseBody
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }
}