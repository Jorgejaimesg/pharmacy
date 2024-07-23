package com.pharmacy.city.aplication;

import java.util.Optional;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class FindCityByNameUseCase {
        private final CityService cityService;

    public FindCityByNameUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> findCityByName(String cityName) {
        return cityService.findCityByName(cityName);
    }

}
