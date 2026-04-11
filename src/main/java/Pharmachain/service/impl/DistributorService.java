package Pharmachain.service.impl;

import Pharmachain.entity.Distributor;
import java.util.List;

public interface DistributorService {
    Distributor saveDistributor(Distributor distributor);
    List<Distributor> getAllDistributors();
    List<Distributor> getActiveDistributors();
    void deleteDistributor(Long id);
}