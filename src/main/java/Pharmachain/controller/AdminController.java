package Pharmachain.controller;

import Pharmachain.entity.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Pharmachain.repository.UserRepository;
import Pharmachain.repository.SaleRepository;
import Pharmachain.repository.SystemLogRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private SystemLogRepository logRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SystemLogRepository systemLogRepository;

    // 1. MASTER CONSOLE: Saari shops/users ki list
    @GetMapping("/master-console")
    public ResponseEntity<?> getMasterData() {
        // Kyunki ShopRepository nahi hai, hum UserRepository use kar rahe hain
        return ResponseEntity.ok(userRepository.findAll());
    }

    // 3. PROBLEM SOLVING: User ka direct message
    @PostMapping("/report-issue")
    public ResponseEntity<?> reportIssue(@RequestBody Map<String, String> report) {
        // Bina naye Model class ke direct Map use kiya hai taki error na aaye
        System.out.println("!!! NEW ISSUE FROM " + report.get("shopName") + " !!!");
        System.out.println("Message: " + report.get("message"));

        return ResponseEntity.ok(Map.of("body", "Issue reported to Sahil. He will contact you soon."));
    }

    // 4. APP VERSION CONTROL
    @PostMapping("/push-update")
    public ResponseEntity<?> pushUpdate(@RequestBody Map<String, String> update) {
        System.out.println("Pushing version " + update.get("version") + " to all shops.");
        return ResponseEntity.ok(Map.of("status", "Update pushed successfully"));
    }

    // 5. SYSTEM HEALTH
    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "System is Live", "developer", "Sahil Dhamecha"));
    }

    @PostMapping("/add-log")
    public ResponseEntity<?> receiveLog(@RequestBody SystemLog log) {
        logRepo.save(log);
        return ResponseEntity.ok("Log saved");
    }

    // Phase 6: Network Stats for Analytics
    @GetMapping("/network-stats")
    public Map<String, Object> getNetworkStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalTurnover", 1250000.0); // Replace with your actual DB sum query
        stats.put("activeShops", 15);
        stats.put("systemStatus", "Running Smoothly");
        return stats;
    }
}