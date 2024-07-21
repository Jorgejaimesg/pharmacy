package com.pharmacy.customer.domain.service;

import java.util.List;
import java.util.Optional;

import com.pharmacy.customer.domain.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer deleteCustomer(String id);
    Optional<Customer> findCustomerById (String id);
    List<Customer> findAllCustomer();
}
