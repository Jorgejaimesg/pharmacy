package com.pharmacy.customer.domain.entity;

public class Customer {
    
        private String id;
        private int typeID;
        private String name;
        private String lastName;
        private int age; 
        private String birthDate;
        private String registrationDate;
        private int cityId;
        private int neighborhoodId;
        public Customer() {
        }
        public Customer(String id, int typeID, String name, String lastName, int age, String birthDate, String registrationDate, int cityId, int neighborhoodId) {
            this.id = id;
            this.typeID = typeID;
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.birthDate = birthDate;
            this.registrationDate = registrationDate;
            this.cityId = cityId;
            this.neighborhoodId = neighborhoodId;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public int getTypeID() {
            return typeID;
        }
        public void setTypeID(int tipeID) {
            this.typeID = tipeID;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getBirthDate() {
            return birthDate;
        }
        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }
        public String getRegistrationDate() {
            return registrationDate;
        }
        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }
        public int getCityId() {
            return cityId;
        }
        public void setCityId(int cityId) {
            this.cityId = cityId;
        }
        public int getNeighborhoodId() {
            return neighborhoodId;
        }
        public void setNeighborhoodId(int neighborhoodId) {
            this.neighborhoodId = neighborhoodId;
        }
    }
    
    
    