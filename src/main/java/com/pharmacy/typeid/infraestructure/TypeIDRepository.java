package com.pharmacy.typeid.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;

public class TypeIDRepository implements TypeIDService{
        private Connection connection;

    public TypeIDRepository() {
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
    public void createTypeID(TypeID typeID) {
            try {
            String query = "INSERT INTO typeid (TypeName) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, typeID.getType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TypeID deleteTypeID(String name) {
        String query = "DELETE FROM typeid WHERE TypeName = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TypeID> findAllTypeID() {
        List<TypeID> Types = new ArrayList<>();
        String query = "SELECT ID, TypeName FROM typeid";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TypeID typeID = new TypeID(
                            rs.getInt("ID"),
                            rs.getString("TypeName"));
                            Types.add(typeID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Types;
    }

    @Override
    public Optional<TypeID> findTypeByName(String Name) {
        String query = "SELECT ID, TypeName FROM typeid WHERE TypeName = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TypeID typeId = new TypeID(
                            rs.getInt("ID"),
                            rs.getString("TypeName"));
                    return Optional.of(typeId);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public Optional<TypeID> findTypeById(int ID) {
        String query = "SELECT ID, TypeName FROM typeid WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TypeID typeId = new TypeID(
                            rs.getInt("ID"),
                            rs.getString("TypeName"));
                    return Optional.of(typeId);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}