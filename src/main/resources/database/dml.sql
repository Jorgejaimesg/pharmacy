CREATE DATABASE phaymacy;

USE phaymacy


INSERT INTO City (CityID, CityName) VALUES
(1, 'Bucaramanga'),
(2, 'Medellín');

INSERT INTO Neighborhood (NeighborhoodID, NeighborhoodName, CityID) VALUES
(1, 'Cabecera del Llano', 1),
(2, 'La Victoria', 1),
(3, 'El Poblado', 2),
(4, 'Laureles', 2);

INSERT INTO TypeID (TypeID, TypeName) VALUES
(1, 'Citizen ID'),
(2, 'Driver License'),
(3, 'Identity Card'),
(4, 'Passport'),
(5, 'Foreign Passport'),
(6, 'Residence Permit');

INSERT INTO Customer (ID, TypeID, Name, LastName, Age, BirthDate, RegistrationDate, CityID, NeighborhoodID) VALUES
(1012345678, 1, 'Andrés', 'García', 30, '1994-05-14', CURRENT_DATE, 1, 1),
(1023456789, 1, 'Luisa', 'Ramírez', 25, '1999-08-21', CURRENT_DATE, 1, 2),
(1034567890, 1, 'Camilo', 'López', 22, '2001-01-15', CURRENT_DATE, 2, 3),
(1045678901, 1, 'Valeria', 'Torres', 28, '1996-03-30', CURRENT_DATE, 2, 4);
