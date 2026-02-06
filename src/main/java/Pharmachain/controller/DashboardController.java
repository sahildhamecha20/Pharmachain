package Pharmachain.controller;

import Pharmachain.dto.DashboardResponseDto;
import Pharmachain.service.impl.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponseDto getDashboard() {
        return dashboardService.getDashboardData();
    }
}