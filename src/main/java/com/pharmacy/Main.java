package com.pharmacy;

import com.pharmacy.city.infraestructure.cityui.CityUI;
import com.pharmacy.customer.infraestructure.customerui.CustomerUI;

public class Main {
    public static void main(String[] args) {
        CityUI cityUI = new CityUI();
        cityUI.startCity();
        // CustomerUI customerUI = new CustomerUI();
        // customerUI.startCustomer();
    }
}
