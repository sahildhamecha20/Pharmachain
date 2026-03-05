package Pharmachain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InventoryBatchResponseDto {
    private Long id;
    private String medicineName;
    private String batchId;
    private Integer quantity;
    private LocalDate expiryDate;
    private Boolean active;
    private Double purchasePrice;
    private Double sellingPrice;
    private LocalDateTime createdAt;

    // Default Constructor
    public InventoryBatchResponseDto() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }

    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }

    public Double getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(Double sellingPrice) { this.sellingPrice = sellingPrice; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

}