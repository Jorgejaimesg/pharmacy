package com.pharmacy.customer.aplication;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class DeleteCustomerUseCase {
    private final CustomerService customerService;

    public DeleteCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer execute(String customerID) {
        return customerService.deleteCustomer(customerID);
    }
}
