package Pharmachain.controller;

import Pharmachain.entity.Distributor;
import Pharmachain.service.impl.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributors")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    @PostMapping
    public Distributor add(@RequestBody Distributor distributor) {
        return distributorService.addDistributor(distributor);
    }

    @GetMapping
    public List<Distributor> activeList() {
        return distributorService.getActiveDistributors();
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        distributorService.deactivateDistributor(id);
    }
}