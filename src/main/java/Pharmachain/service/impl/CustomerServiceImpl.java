package Pharmachain.service.impl;

import Pharmachain.entity.Customer;
import Pharmachain.entity.Purchase;
import Pharmachain.repository.CustomerRepository;
import Pharmachain.repository.PurchaseRepository;
import Pharmachain.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
