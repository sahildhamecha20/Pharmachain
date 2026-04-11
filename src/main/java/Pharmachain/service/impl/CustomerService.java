package Pharmachain.service.impl;

import Pharmachain.entity.Customer;
import Pharmachain.entity.Purchase;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
