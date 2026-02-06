package Pharmachain.dto;

import java.time.LocalDate;

public class InventoryBatchRequestDto {
    private String medicineName;
    private String batchNo;
    private Integer quantity;
    private LocalDate expiryDate;
    private Double purchasePrice;
    private Double sellingPrice;

    public String getMedicineName() { return medicineName; }
    public String getBatchNo() { return batchNo; }
    public Integer getQuantity() { return quantity; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public Double getPurchasePrice() { return purchasePrice; }
    public Double getSellingPrice() { return sellingPrice; }

    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public void setBatchNo(String batchNo) { this.batchNo = batchNo; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setSellingPrice(Double sellingPrice) { this.sellingPrice = sellingPrice; }
}