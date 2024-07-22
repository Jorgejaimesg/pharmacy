package com.pharmacy.customer.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class CustomerRepository implements CustomerService {
    private Connection connection;

    public CustomerRepository() {
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
    public void createCustomer(Customer customer) {
        try{
            String query = "INSERT INTO customer(ID, TypeID, Name, LastName, Age, BirthDate, RegistrationDate, CityID, NeighborhoodID) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps  = connection.prepareStatement(query);
            ps.setString(1,customer.getId());
            ps.setInt(2,customer.getTypeID());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getLastName());
            ps.setInt(5, customer.getAge());
            ps.setString(6, customer.getBirthDate());
            ps.setString(7, customer.getRegistrationDate());
            ps.setInt(8, customer.getCityId());
            ps.setInt(9, customer.getNeighborhoodId());
            ps.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customer SET TypeID = ?, Name = ?, LastName = ?, Age = ?, BirthDate = ?, RegistrationDate = ?, CityID = ?, NeighborhoodID = ? WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customer.getTypeID());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getLastName());
            ps.setInt(4, customer.getAge());
            ps.setString(5, customer.getBirthDate());
            ps.setString(6, customer.getRegistrationDate());
            ps.setInt(7, customer.getCityId());
            ps.setInt(8, customer.getNeighborhoodId());
            ps.setString(9, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer deleteCustomer(String ID) {
        String query = "DELETE FROM customer WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Customer> findCustomerById(String ID) {
        String query = "SELECT ID, TypeID, Name, LastName, Age, BirthDate, RegistrationDate, CityID, NeighborhoodID FROM Customer WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Customer customer = new Customer(
                                        rs.getString("ID"), 
                                        rs.getInt("TypeID"), 
                                        rs.getString("Name"),  
                                        rs.getString("LastName"), 
                                        rs.getInt("Age"), 
                                        rs.getString("BirthDate"), 
                                        rs.getString("RegistrationDate"), 
                                        rs.getInt("CityID"),
                                        rs.getInt("NeighborhoodID")
                                        );
                        return Optional.of(customer);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT ID, TypeID, Name, LastName, Age, BirthDate, RegistrationDate, CityID, NeighborhoodID FROM customer";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Customer customer = new Customer(
                        rs.getString("ID"), 
                        rs.getInt("TypeID"), 
                        rs.getString("Name"),  
                        rs.getString("LastName"), 
                        rs.getInt("Age"), 
                        rs.getString("BirthDate"), 
                        rs.getString("RegistrationDate"), 
                        rs.getInt("CityID"),
                        rs.getInt("NeighborhoodID")
                    );
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;   
}

}
