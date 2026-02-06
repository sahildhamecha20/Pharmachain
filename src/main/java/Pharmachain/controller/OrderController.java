package Pharmachain.controller;

import Pharmachain.dto.OrderRequestDTO;
import Pharmachain.dto.OrderResponseDTO;
import Pharmachain.entity.Order;
import Pharmachain.service.impl.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponseDTO placeOrder(
            @Valid @RequestBody OrderRequestDTO dto) {

        Order order = orderService.placeOrder(
                dto.getBatchId(),
                dto.getQuantity()
        );

        return new OrderResponseDTO(
                order.getOrderNumber(),
                order.getQuantity(),
                order.getOrderDate()
        );
    }
}