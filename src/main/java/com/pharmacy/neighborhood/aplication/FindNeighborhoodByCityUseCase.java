package com.pharmacy.neighborhood.aplication;

import java.util.List;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class FindNeighborhoodByCityUseCase {
    private final NeighborhoodService neighborhoodService;

    public FindNeighborhoodByCityUseCase(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public List<Neighborhood> findAllNeighborhoodByCity(int CityID) {
        return neighborhoodService.findAllNeighborhoodByCity(CityID);
    }
}
