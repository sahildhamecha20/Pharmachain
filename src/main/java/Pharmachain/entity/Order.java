package Pharmachain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private int quantity;

    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private InventoryBatch inventoryBatch;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public InventoryBatch getInventoryBatch() {
        return inventoryBatch;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setInventoryBatch(InventoryBatch inventoryBatch) {
        this.inventoryBatch = inventoryBatch;
    }
}