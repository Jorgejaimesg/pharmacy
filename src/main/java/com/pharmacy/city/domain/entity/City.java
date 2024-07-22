package com.pharmacy.city.domain.entity;

public class City {
    private int id;
    private String name;

    public City() {
    }

    public City(int cityId, String cityName) {
        this.id = cityId;
        this.name = cityName;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int cityId) {
        this.id = cityId;
    }
    public String getName() {
        return name;
    }
    public void setName(String cityName) {
        this.name = cityName;
    }
    
}
