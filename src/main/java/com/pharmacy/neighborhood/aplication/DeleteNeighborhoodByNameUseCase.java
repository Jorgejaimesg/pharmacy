package com.pharmacy.neighborhood.aplication;

import java.util.Optional;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class DeleteNeighborhoodByNameUseCase {
    private final NeighborhoodService neighborhoodService;

    public DeleteNeighborhoodByNameUseCase(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public Optional<Neighborhood> execute(int CityID, String Name ) {
        return neighborhoodService.deleteNeighborhoodByName(CityID, Name);
    }
}
