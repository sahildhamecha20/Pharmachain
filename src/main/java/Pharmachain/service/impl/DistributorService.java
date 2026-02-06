package Pharmachain.service.impl;

import Pharmachain.entity.Distributor;
import java.util.List;

public interface DistributorService {

    Distributor addDistributor(Distributor distributor);

    List<Distributor> getActiveDistributors();

    void deactivateDistributor(Long id);
}