package com.pharmacy;

import com.pharmacy.city.infraestructure.cityui.CityUI;
import com.pharmacy.customer.infraestructure.customerui.CustomerUI;
import com.pharmacy.main.infraestructure.MainUI;
import com.pharmacy.neighborhood.infraestructure.neighborhoodui.NeighborhoodUI;
import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.infraestructure.typeui.TypeUI;

public class Main {
    public static void main(String[] args) {
        MainUI MainUI = new MainUI();
        MainUI.startMenu();
        }
}
