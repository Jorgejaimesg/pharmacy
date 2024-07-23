package com.pharmacy.neighborhood.aplication;

import java.util.List;

import com.pharmacy.neighborhood.domain.entity.NeighborhoodShow;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class FindAllNeighborhoodUseCase {
    private final NeighborhoodService neighborhoodService;

    public FindAllNeighborhoodUseCase(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public List<NeighborhoodShow> findAllNeighborhood() {
        return neighborhoodService.findAllNeighborhood();
    }
}
