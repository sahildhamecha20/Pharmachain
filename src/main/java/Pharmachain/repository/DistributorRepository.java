package Pharmachain.repository;

import Pharmachain.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {

    List<Distributor> findByActiveTrue();
}