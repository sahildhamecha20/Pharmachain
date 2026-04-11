package Pharmachain.Dto;

public class CartItemDTO {
    private Long batchId;
    private Integer quantity;


    public CartItemDTO() {}

    public Long getBatchId() { return batchId; }
    public void setBatchId(Long batchId) { this.batchId = batchId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}