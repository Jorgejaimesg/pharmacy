package com.pharmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.pharmacy.city.domain.entity.City;

public interface CityService {
        void createCity(City city);
        void updateCity(City city);
        City deleteCity(String id);
        Optional<City> findCityByName (String Name);
        List<City> findAllCity();
    }
    

