package com.pharmacy.customer.domain.service;

import java.util.List;

import com.pharmacy.customer.domain.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer deleteCustomer(String id);
    Customer findCustomerById (String id);
    List<Customer> findAllCustomer();
}
