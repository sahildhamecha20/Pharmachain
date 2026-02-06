package Pharmachain.service.impl;

import Pharmachain.entity.InventoryBatch;
import Pharmachain.entity.Order;
import Pharmachain.repository.InventoryBatchRepository;
import Pharmachain.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InventoryBatchRepository batchRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Long batchId, int quantity) {

        InventoryBatch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        if (batch.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        // ✅ Auto reduce stock
        batch.setQuantity(batch.getQuantity() - quantity);
        batchRepository.save(batch);

        // ✅ Create order
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setQuantity(quantity);
        order.setOrderDate(LocalDateTime.now());
        order.setInventoryBatch(batch);

        return orderRepository.save(order);
    }
}