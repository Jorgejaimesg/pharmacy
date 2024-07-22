package com.pharmacy.city.aplication;
import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class DeleteCityUseCase {
    private final CityService cityService;

    public DeleteCityUseCase (CityService cityService) {
        this.cityService = cityService;
    }

    public City execute(String ID) {
        return cityService.deleteCity(ID);
    }
}
