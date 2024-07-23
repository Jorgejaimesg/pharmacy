package com.pharmacy.neighborhood.aplication;

import java.util.Optional;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class FindNeighborhoodByNameUseCase {
    private final NeighborhoodService neighborhoodService;

    public FindNeighborhoodByNameUseCase(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public Optional<Neighborhood> execute(int CityID, String Name ) {
        return neighborhoodService.findNeighborhoodByName(CityID, Name);
    }
}
