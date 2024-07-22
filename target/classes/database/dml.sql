
INSERT INTO City (Name) VALUES
('Bucaramanga'),
('Medellín');

INSERT INTO Neighborhood (Name, CityID) VALUES
('Cabecera del Llano', 1),
('La Victoria', 1),
('El Poblado', 2),
('Laureles', 2);


INSERT INTO TypeID (TypeName) VALUES
('Citizen ID'),
('Driver License'),
('Identity Card'),
('Passport'),
('Foreign Passport'),
('Residence Permit');

INSERT INTO Customer (ID, TypeID, Name, LastName, Age, BirthDate, RegistrationDate, CityID, NeighborhoodID) VALUES
(1012345678, 1, 'Andrés', 'García', 30, '1994-05-14', CURDATE(), 1, 1),
(1023456789, 1, 'Luisa', 'Ramírez', 25, '1999-08-21', CURDATE(), 1, 2),
(1034567890, 1, 'Camilo', 'López', 22, '2001-01-15', CURDATE(), 2, 3),
(1045678901, 1, 'Valeria', 'Torres', 28, '1996-03-30', CURDATE(), 2, 4);
