package Pharmachain.service.impl;

import Pharmachain.dto.DashboardResponseDto;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public DashboardResponseDto getDashboardData() {
        DashboardResponseDto dto = new DashboardResponseDto();

        // Dummy values (replace with DB queries)
        dto.setTotalStock(1240);
        dto.setTotalRevenue(98500.50);
        dto.setTotalSales(342);

        return dto;
    }
}