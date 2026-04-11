package Pharmachain.service.impl;

import Pharmachain.entity.InventoryBatch;
import Pharmachain.entity.Order;
import Pharmachain.repository.InventoryBatchRepository;
import Pharmachain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryBatchRepository batchRepository;

    @Override
    public Order placeOrder(Order order, Long batchId) {
        // 1. Batch dhoondo jiske liye order ho raha hai
        InventoryBatch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Inventory Batch not found with ID: " + batchId));

        // 2. Relationship set karo
        order.setInventoryBatch(batch);

        // 3. Order ki default details (Agar date null hai toh)
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDateTime.now());
        }

        // 4. Save order
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}