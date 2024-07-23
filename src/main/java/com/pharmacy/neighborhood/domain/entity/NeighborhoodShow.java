package com.pharmacy.neighborhood.domain.entity;

public class NeighborhoodShow {
    private int id;
    private String name;
    private String city;
    public NeighborhoodShow() {
    }
    public NeighborhoodShow(int id, String name, String string) {
        this.id = id;
        this.name = name;
        this.city = string;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
