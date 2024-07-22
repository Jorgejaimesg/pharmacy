CREATE DATABASE pharmacy;

USE pharmacy;

CREATE TABLE City (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50)
);

CREATE TABLE Neighborhood (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50),
    CityID INT,
    FOREIGN KEY (CityID) REFERENCES City(ID)
);

CREATE TABLE TypeID (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    TypeName VARCHAR(50)
);

CREATE TABLE Customer (
    ID VARCHAR(20) PRIMARY KEY,
    TypeID INT,
    Name VARCHAR(30),
    LastName VARCHAR(10),
    Age INT,
    BirthDate DATE,
    RegistrationDate DATE DEFAULT (CURDATE()),
    CityID INT,
    NeighborhoodID INT,
    FOREIGN KEY (CityID) REFERENCES City(ID),
    FOREIGN KEY (NeighborhoodID) REFERENCES Neighborhood(ID),
    FOREIGN KEY (TypeID) REFERENCES TypeID(ID)
);
