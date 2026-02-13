package Pharmachain.controller;

import Pharmachain.entity.Sale;

import Pharmachain.service.impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminDashboardController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/earnings")
    public Map<String, Object> getMyEarnings() {
        List<Sale> allSales = saleService.getAllSales();

        double totalBusiness = allSales.stream().mapToDouble(Sale::getTotalBillAmount).sum();
        double totalCommission = allSales.stream().mapToDouble(Sale::getCommissionEarned).sum();

        Map<String, Object> report = new HashMap<>();
        report.put("totalSalesCount", allSales.size());
        report.put("totalTurnover", totalBusiness);
        report.put("myTotalEarnings", totalCommission);

        return report;
    }
}