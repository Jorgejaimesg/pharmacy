package com.pharmacy.neighborhood.domain.service;

import java.util.List;
import java.util.Optional;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.entity.NeighborhoodShow;

public interface NeighborhoodService {
        void createNeighborhood(Neighborhood neighborhood);
        List<NeighborhoodShow> findAllNeighborhood();
        List<Neighborhood> findAllNeighborhoodByCity(int CityID);
        Optional<Neighborhood> deleteNeighborhoodByName(int cityID, String name);
        Optional<Neighborhood> findNeighborhoodByName(int cityID, String name);
        Optional<Neighborhood> findNeighborhoodByID(int NeighborhoodID);
}
