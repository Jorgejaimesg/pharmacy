package com.pharmacy.city.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository() {
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
    public void createCity(City city) {
        try {
            String query = "INSERT INTO city (Name) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, city.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City deleteCity(String Name) {
        String query = "DELETE FROM city WHERE Name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> findAllCity() {
        List<City> cities = new ArrayList<>();
        String query = "SELECT ID, Name FROM city";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City city = new City(
                            rs.getInt("ID"),
                            rs.getString("Name"));
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public Optional<City> findCityByName(String Name) {
        String query = "SELECT ID, NAME FROM city WHERE Name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City city = new City(
                            rs.getInt("ID"),
                            rs.getString("Name"));
                    return Optional.of(city);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public Optional<City> findCityById(int Id) {
        String query = "SELECT ID, NAME FROM city WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, Id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City city = new City(
                            rs.getInt("ID"),
                            rs.getString("Name"));
                    return Optional.of(city);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    }


