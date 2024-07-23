package com.pharmacy.city.aplication;

import java.util.List;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class FindAllCityUseCase {
    private final CityService cityService;

    public FindAllCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> findAllCity() {
        return cityService.findAllCity();
    }
}
