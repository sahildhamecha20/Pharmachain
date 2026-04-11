package Pharmachain.service.impl;

import Pharmachain.Dto.SaleRequestDTO;
import Pharmachain.entity.Sale;
import java.util.List;

public interface SaleService {
    Sale processSale(SaleRequestDTO saleRequest);
    List<Sale> getSaleHistory();
}