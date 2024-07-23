package com.pharmacy.neighborhood.aplication;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class CreateNeighborhoodUseCase {
        private final NeighborhoodService neighborhoodService;

    public CreateNeighborhoodUseCase(NeighborhoodService neighborhoodService){
        this.neighborhoodService = neighborhoodService;
    }

    public void execute(Neighborhood neighborhood){
        neighborhoodService.createNeighborhood(neighborhood);
}
}
