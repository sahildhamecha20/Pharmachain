package Pharmachain.repository;

import Pharmachain.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT SUM(p.totalAmount) FROM Purchase p WHERE p.purchaseDate = CURRENT_DATE")
    Double getTotalPurchaseToday();
}