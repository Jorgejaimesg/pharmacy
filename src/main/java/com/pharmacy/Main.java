package com.pharmacy;


import com.pharmacy.customer.infraestructure.customerui.CustomerUI;

public class Main {
    public static void main(String[] args) {
        CustomerUI uiCustomer = new CustomerUI();
        uiCustomer.startCustomer();
    }
}
