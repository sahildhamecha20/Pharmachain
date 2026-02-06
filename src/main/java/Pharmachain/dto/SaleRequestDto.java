package Pharmachain.dto;

public class SaleRequestDto {
    private String medicineName;
    private String batchNo;
    private Integer quantity;


    public String getMedicineName() { return medicineName; }
    public String getBatchNo() { return batchNo; }
    public void setBatchNo(String batchNo) { this.batchNo = batchNo; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}