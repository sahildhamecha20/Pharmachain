package Pharmachain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalBillAmount;
    private Double commissionEarned;
    private LocalDateTime saleDate = LocalDateTime.now();
    private String invoiceNumber;
    private String paymentMode;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public static final String RETURN_POLICY = "Once sold, medicine cannot be returned.";

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTotalBillAmount() { return totalBillAmount; }
    public void setTotalBillAmount(Double totalBillAmount) { this.totalBillAmount = totalBillAmount; }

    public Double getCommissionEarned() { return commissionEarned; }
    public void setCommissionEarned(Double commissionEarned) { this.commissionEarned = commissionEarned; }

    public LocalDateTime getSaleDate() { return saleDate; }
    public void setSaleDate(LocalDateTime saleDate) { this.saleDate = saleDate; }
}