package Pharmachain.service.impl;

import Pharmachain.entity.SalesLedger;
import Pharmachain.Dto.BillItem;
import java.util.List;

public interface BillingService {

    SalesLedger processSale(List<BillItem> items, String customerName, String type);
}