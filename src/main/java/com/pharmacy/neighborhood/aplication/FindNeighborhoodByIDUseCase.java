package com.pharmacy.neighborhood.aplication;

import java.util.Optional;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class FindNeighborhoodByIDUseCase {
        private final NeighborhoodService neighborhoodService;

    public FindNeighborhoodByIDUseCase(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public Optional<Neighborhood> findNeighborhoodByID(int neighborhoodBox) {
        return neighborhoodService.findNeighborhoodByID(neighborhoodBox);
    }
}
