package com.pharmacy.customer.aplication;

import java.util.List;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class FindAllCustomersUseCase {
private final CustomerService customerService;

    public FindAllCustomersUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> findAllCustomer() {
        return customerService.findAllCustomer();
    }
}
