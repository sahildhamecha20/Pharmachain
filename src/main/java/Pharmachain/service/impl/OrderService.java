package Pharmachain.service.impl;

import Pharmachain.entity.Order;

public interface OrderService {
    Order placeOrder(Long batchId, int quantity);
}