package Pharmachain.repository;

import Pharmachain.entity.StockAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockAuditRepository
        extends JpaRepository<StockAuditLog, Long> {
}