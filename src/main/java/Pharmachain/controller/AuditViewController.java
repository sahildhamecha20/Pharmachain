package Pharmachain.controller;

import Pharmachain.repository.StockAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuditViewController {

    @Autowired
    private StockAuditRepository auditRepo;

    @GetMapping("/audit")
    public String viewAudit(Model model) {
        model.addAttribute("logs", auditRepo.findAll());
        return "audit";
    }
}