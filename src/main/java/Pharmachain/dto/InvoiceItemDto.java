package Pharmachain.dto;

public class InvoiceItemDto {

    private String medicineName;
    private String batchNo;
    private String expirydate;
    private int quantity;
    private double price;

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public String getExpiryDate() {
        return expirydate;
    }

    public void setExpiryDate(String expirydate) {
        this.expirydate = expirydate;
    }

    private double gst;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}