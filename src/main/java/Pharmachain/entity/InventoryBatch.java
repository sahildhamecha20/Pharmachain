package Pharmachain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "inventory_batches")
@Data
public class InventoryBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNo;
    private Integer quantity;
    private LocalDate expiryDate;
    private double sellingPrice;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    // Manual method for Service compatibility
    public String getBatchNumber() {
        return this.batchNo;
    }
}