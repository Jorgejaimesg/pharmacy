package com.pharmacy.neighborhood.domain.entity;

public class Neighborhood {
    private int id;
    private String name;
    private int cityId;

    public Neighborhood() {
    }

    public Neighborhood(int id, String name, int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }


    public int getId() {
        return id;
    }
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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
