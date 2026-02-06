package Pharmachain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderRequestDTO {

    @NotNull(message = "Batch ID is required")
    private Long batchId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    public Long getBatchId() {
        return batchId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}