package com.pharmacy.neighborhood.infraestructure;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.entity.NeighborhoodShow;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;

public class NeighborhoodRepository implements NeighborhoodService {
        private Connection connection;
        public NeighborhoodRepository() {
            try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("pharmacydb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    @Override
    public void createNeighborhood(Neighborhood neighborhood) {
        try {
            String query = "INSERT INTO neighborhood (Name, CityID) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, neighborhood.getName());
            ps.setInt(2, neighborhood.getCityId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<NeighborhoodShow> findAllNeighborhood() {
        List<NeighborhoodShow> neighborhoods = new ArrayList<>();
        String query = "SELECT n.ID, n.Name , c.Name as City FROM neighborhood n JOIN city c ON c.ID = n.CityID";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    NeighborhoodShow neighborhood = new NeighborhoodShow(
                            rs.getInt("ID"),
                            rs.getString("Name"),
                            rs.getString("City"));
                            neighborhoods.add(neighborhood);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neighborhoods;
    }
    @Override
    public List<Neighborhood> findAllNeighborhoodByCity(int CityID) {
        List<Neighborhood> neighborhoods = new ArrayList<>();
        String query = "SELECT ID, Name FROM neighborhood where CityID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, CityID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Neighborhood neighborhood = new Neighborhood(
                            rs.getInt("ID"),
                            rs.getString("Name"), CityID);
                            neighborhoods.add(neighborhood);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neighborhoods;
    }
    @Override
    public Optional<Neighborhood> deleteNeighborhoodByName(int cityID, String Name) {
        String query = "DELETE FROM neighborhood WHERE (CityID = ? && Name = ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cityID);
            ps.setString(2, Name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
    @Override
    public Optional<Neighborhood> findNeighborhoodByName(int cityID, String name) {
        String query = "SELECT ID, Name, CityID FROM neighborhood WHERE (Name = ? && CityID = ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, cityID);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Neighborhood neighborhood = new Neighborhood(
                            rs.getInt("ID"),
                            rs.getString("Name"),
                            rs.getInt("CityID"));
                    return Optional.of(neighborhood);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    @Override
    public Optional<Neighborhood> findNeighborhoodByID(int NeighborhoodID) {
        String query = "SELECT ID, Name, CityID FROM neighborhood WHERE ID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, NeighborhoodID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Neighborhood neighborhood = new Neighborhood(
                            rs.getInt("ID"),
                            rs.getString("Name"),
                            rs.getInt("CityID"));
                    return Optional.of(neighborhood);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}