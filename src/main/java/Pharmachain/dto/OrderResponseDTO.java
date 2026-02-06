package Pharmachain.dto;

import java.time.LocalDateTime;

public class OrderResponseDTO {

    private String orderNumber;
    private int quantity;
    private LocalDateTime orderDate;

    public OrderResponseDTO(String orderNumber, int quantity, LocalDateTime orderDate) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.orderDate = orderDate;
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


    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}