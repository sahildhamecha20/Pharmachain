package Pharmachain.repository;

import Pharmachain.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

    List<Distributor> findByActiveTrue();
}