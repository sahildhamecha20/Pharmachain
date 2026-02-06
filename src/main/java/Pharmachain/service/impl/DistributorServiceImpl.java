package Pharmachain.service.impl;

import Pharmachain.entity.Distributor;
import Pharmachain.repository.DistributorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DistributorServiceImpl implements DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    @Override
    public Distributor addDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    @Override
    public List<Distributor> getActiveDistributors() {
        return distributorRepository.findByActiveTrue();
    }

    @Override
    public void deactivateDistributor(Long id) {
        Distributor d = distributorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distributor not found"));

        d.setActive(false);
        distributorRepository.save(d);
    }
}