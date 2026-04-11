package Pharmachain.service.impl;

import Pharmachain.entity.Order;
import java.util.List;

public interface OrderService {
    Order placeOrder(Order order, Long batchId);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
}