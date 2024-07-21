CREATE DATABASE phaymacy;

USE phaymacy;

CREATE TABLE City (
    CityID INT PRIMARY KEY,
    CityName VARCHAR(50)
);

CREATE TABLE Neighborhood (
    NeighborhoodID INT PRIMARY KEY,
    NeighborhoodName VARCHAR(50),
    CityID INT,
    FOREIGN KEY (CityID) REFERENCES City(CityID)
);

CREATE TABLE TypeID (
    TypeID INT PRIMARY KEY,
    TypeName VARCHAR(50)
);

CREATE TABLE Customer (
    ID VARCHAR(20) PRIMARY KEY,
    TypeID INT,
    Name VARCHAR(10),
    LastName VARCHAR(10),
    Age INT,
    BirthDate DATE,
    RegistrationDate DATE DEFAULT (CURDATE()),
    CityID INT,
    NeighborhoodID INT,
    FOREIGN KEY (CityID) REFERENCES City(CityID),
    FOREIGN KEY (NeighborhoodID) REFERENCES Neighborhood(NeighborhoodID),
    FOREIGN KEY (TypeID) REFERENCES TypeID(TypeID)
);