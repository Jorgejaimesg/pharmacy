package com.pharmacy.customer.aplication;

import java.util.Optional;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class FindCustomerUseCase {
    private final CustomerService customerService;

    public FindCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> execute(String id) {
        return customerService.findCustomerById(id);
    }
}
