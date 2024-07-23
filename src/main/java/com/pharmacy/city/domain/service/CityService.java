package com.pharmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.pharmacy.city.domain.entity.City;

public interface CityService {
        void createCity(City city);
        City deleteCity(String Name);
        Optional<City> findCityByName (String Name);
        Optional<City> findCityById (int Id);
        List<City> findAllCity();
    }
    

