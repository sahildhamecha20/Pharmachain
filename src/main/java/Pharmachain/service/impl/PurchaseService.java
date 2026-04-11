package Pharmachain.service.impl;

import Pharmachain.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(Purchase purchase);
    List<Purchase> getAllPurchases();
    Double getTodayPurchase();
}