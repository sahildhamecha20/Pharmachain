package Pharmachain.service.impl;

import Pharmachain.dto.SaleRequestDto;
import Pharmachain.entity.Sale;
import java.util.List;

public interface SaleService {
    Sale createBill(SaleRequestDto request);
    List<Sale> getAllSales();
}