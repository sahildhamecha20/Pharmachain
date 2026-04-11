package Pharmachain.repository;

import Pharmachain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>
{
        @Query("SELECT COALESCE(SUM(s.totalBillAmount), 0.0) FROM Sale s WHERE s.saleDate = CURRENT_DATE")
        Double getTotalSalesToday();
    }
