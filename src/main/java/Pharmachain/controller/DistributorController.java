package Pharmachain.controller;

import Pharmachain.entity.Distributor;
import Pharmachain.service.impl.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distributors")
@CrossOrigin("*")
public class DistributorController {

    @Autowired
    private DistributorService service;

    @PostMapping("/save")
    public ResponseEntity<Distributor> add(@RequestBody Distributor distributor) {
        return ResponseEntity.ok(service.saveDistributor(distributor));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Distributor>> getAll() {
        return ResponseEntity.ok(service.getAllDistributors());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Distributor>> getActive() {
        return ResponseEntity.ok(service.getActiveDistributors());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteDistributor(id);
        return ResponseEntity.ok("Distributor removed successfully");
    }
}