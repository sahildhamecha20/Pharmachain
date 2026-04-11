package Pharmachain.repository;

import Pharmachain.entity.BillType;
import Pharmachain.entity.SalesLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesLedgerRepository extends JpaRepository<SalesLedger, Long> {
    List<SalesLedger> findBySaleDateBetweenAndBillType(LocalDateTime start, LocalDateTime end, BillType type);
}