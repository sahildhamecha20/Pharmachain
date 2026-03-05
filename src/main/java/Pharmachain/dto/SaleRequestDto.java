package Pharmachain.dto;

public class SaleRequestDto {
    private String medicineName;
    private String batchId;
    private Integer quantity;


    public String getMedicineName() { return medicineName; }
    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}