package Pharmachain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_audit_logs")
public class StockAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long medicineId;
    private String batchNo;
    private Integer oldQty;
    private Integer newQty;
    private String action;
    private String changedBy;
    private LocalDateTime changedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMedicineId() { return medicineId; }
    public void setMedicineId(Long medicineId) { this.medicineId = medicineId; }

    public String getBatchNo() { return batchNo; }
    public void setBatchNo(String batchNo) { this.batchNo = batchNo; }

    public Integer getOldQty() { return oldQty; }
    public void setOldQty(Integer oldQty) { this.oldQty = oldQty; }

    public Integer getNewQty() { return newQty; }
    public void setNewQty(Integer newQty) { this.newQty = newQty; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getChangedBy() { return changedBy; }
    public void setChangedBy(String changedBy) { this.changedBy = changedBy; }

    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
}