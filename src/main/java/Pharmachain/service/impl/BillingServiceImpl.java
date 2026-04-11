package Pharmachain.service.impl;
import Pharmachain.Dto.BillItem;
import Pharmachain.entity.BillType;
import Pharmachain.entity.SalesLedger;
import Pharmachain.repository.SalesLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private SalesLedgerRepository repository;

    @Override
    @Transactional
    public SalesLedger processSale(List<BillItem> items, String customerName, String type) {
        double taxable = 0, totalGst = 0, totalPurchase = 0;

        for (BillItem item : items) {
            totalPurchase += item.getPurchaseRate() * item.getQty();
            taxable += item.getPrice() * item.getQty();

            if ("GST_TAX_INVOICE".equals(type)) {
                totalGst += (item.getPrice() * item.getGstRate() / 100) * item.getQty();
            }
        }

        SalesLedger ledger = new SalesLedger();
        ledger.setCustomerName(customerName);
        ledger.setBillType(BillType.valueOf(type));
        ledger.setTaxableValue(taxable);
        ledger.setGstAmount(totalGst);
        ledger.setGrandTotal(taxable + totalGst);
        ledger.setPurchaseCost(totalPurchase);

        return repository.save(ledger);
    }
}