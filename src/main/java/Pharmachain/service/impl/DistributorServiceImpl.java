package Pharmachain.service.impl;

import Pharmachain.entity.Distributor;
import Pharmachain.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistributorServiceImpl implements DistributorService {

    @Autowired
    private DistributorRepository repository;

    @Override
    public Distributor saveDistributor(Distributor distributor) {
        return repository.save(distributor);
    }

    @Override
    public List<Distributor> getAllDistributors() {
        return repository.findAll();
    }

    @Override
    public List<Distributor> getActiveDistributors() {
        return repository.findByActiveTrue();
    }

    @Override
    public void deleteDistributor(Long id) {
        repository.deleteById(id);
    }
}