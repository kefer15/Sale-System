
-- Create data base -----------------------------------------------------

DROP DATABASE IF EXISTS  BD_SALE_SYSTEM ;

CREATE DATABASE BD_SALE_SYSTEM;
USE BD_SALE_SYSTEM;

-- Create tables section -------------------------------------------------

-- Table Usuario

CREATE TABLE Usuario
(
  UsuCod Int(3) ZEROFILL NOT NULL AUTO_INCREMENT,
  UsuIde Char(10) NOT NULL,
  UsuCon Char(20) NOT NULL,
  UsuNom Char(40) NOT NULL,
  UsuApePat Char(20) NOT NULL,
  UsuApeMat Char(20) NOT NULL,
  UsuDni Char(8) NOT NULL,
  GenCod Int(1) ZEROFILL,
  UsuDir Char(100),
  CarCod Int(3) ZEROFILL,
  UsuCel Char(9) NOT NULL,
  UsuCorEle Char(60) NOT NULL,
  UsuNumEme Char(9) NOT NULL,
  UsuOtr Char(100),
  EstCod Int(2) ZEROFILL,
 PRIMARY KEY (UsuCod),
 UNIQUE UsuCod (UsuCod)
);

ALTER TABLE Usuario ADD UNIQUE UseId (UsuIde);
CREATE INDEX IX_Relationship2 ON Usuario (CarCod);
CREATE INDEX IX_Relationship3 ON Usuario (GenCod);
CREATE INDEX IX_Relationship9 ON Usuario (EstCod);

-- Table Cargo

CREATE TABLE Cargo
(
  CarCod Int(3) ZEROFILL NOT NULL AUTO_INCREMENT,
  CarNom Char(50) NOT NULL,
 PRIMARY KEY (CarCod),
 UNIQUE CarCod (CarCod)
);

ALTER TABLE Cargo ADD UNIQUE CarNom (CarNom);

-- Table Proveedor

CREATE TABLE Proveedor
(
  ProCod Int(3) ZEROFILL NOT NULL AUTO_INCREMENT,
  ProNom Char(50) NOT NULL,
  ProRuc Char(12) NOT NULL,
  ProTel Char(9) NOT NULL,
  ProDir Char(100),
  EstCod Int(2) ZEROFILL,
 PRIMARY KEY (ProCod),
 UNIQUE ProCod (ProCod)
);

ALTER TABLE Proveedor ADD UNIQUE ProNom (ProNom);
ALTER TABLE Proveedor ADD UNIQUE ProRuc (ProRuc);
CREATE INDEX IX_Relationship11 ON Proveedor (EstCod);

-- Table Genero

CREATE TABLE Genero
(
  GenCod Int(1) ZEROFILL NOT NULL AUTO_INCREMENT,
  GenNom Char(20) NOT NULL,
 PRIMARY KEY (GenCod),
 UNIQUE GenCod (GenCod)
);

ALTER TABLE Genero ADD UNIQUE GenNom (GenNom);

-- Table Producto

CREATE TABLE Producto
(
  ProdCod Int(5) ZEROFILL NOT NULL AUTO_INCREMENT,
  ProdNom Char(30) NOT NULL,
  ProdMar Char(50) NOT NULL,
  ProdPres Char(20),
  ProdPrec Double NOT NULL,
  ProdSto Int NOT NULL,
  CatCod Int(3) ZEROFILL,
  EstCod Int(2) ZEROFILL,
 PRIMARY KEY (ProdCod),
 UNIQUE ProdCod (ProdCod)
);

CREATE INDEX IX_Relationship1 ON Producto (CatCod);
CREATE INDEX IX_Relationship10 ON Producto (EstCod);

-- Table Estado

CREATE TABLE Estado
(
  EstCod Int(2) ZEROFILL NOT NULL AUTO_INCREMENT,
  EstNom Char(20) NOT NULL,
 PRIMARY KEY (EstCod),
 UNIQUE EstCod (EstCod)
);

ALTER TABLE Estado ADD UNIQUE EstNom (EstNom);

-- Table Categoria

CREATE TABLE Categoria
(
  CatCod Int(3) ZEROFILL NOT NULL AUTO_INCREMENT,
  CatNom Char(50) NOT NULL,
 PRIMARY KEY (CatCod),
 UNIQUE CatCod (CatCod)
);

ALTER TABLE Categoria ADD UNIQUE CatNom (CatNom);

-- Table ProProd

CREATE TABLE ProProd
(
  ProdCod Int(5) ZEROFILL NOT NULL,
  ProCod Int(3) ZEROFILL NOT NULL
);

ALTER TABLE ProProd ADD PRIMARY KEY (ProdCod,ProCod);

-- Create relationships section ------------------------------------------------- 

ALTER TABLE Usuario ADD CONSTRAINT Relationship2 FOREIGN KEY (CarCod) REFERENCES Cargo (CarCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Usuario ADD CONSTRAINT Relationship3 FOREIGN KEY (GenCod) REFERENCES Genero (GenCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Usuario ADD CONSTRAINT Relationship9 FOREIGN KEY (EstCod) REFERENCES Estado (EstCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Producto ADD CONSTRAINT Relationship10 FOREIGN KEY (CatCod) REFERENCES Categoria (CatCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Producto ADD CONSTRAINT Relationship12 FOREIGN KEY (EstCod) REFERENCES Estado (EstCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Proveedor ADD CONSTRAINT Relationship13 FOREIGN KEY (EstCod) REFERENCES Estado (EstCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProProd ADD CONSTRAINT Relationship14 FOREIGN KEY (ProdCod) REFERENCES Producto (ProdCod) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProProd ADD CONSTRAINT Relationship15 FOREIGN KEY (ProCod) REFERENCES Proveedor (ProCod) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- Create views section ------------------------------------------------- 

CREATE VIEW Usuario_Cargo
	AS SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, GenNom, UsuDir, CarNom, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, EstNom
	FROM Usuario, Cargo, Genero, Estado
	WHERE Usuario.GenCod = Genero.GenCod AND Usuario.CarCod = Cargo.CarCod AND Usuario.EstCod = Estado.EstCod
ORDER BY UsuNom;

CREATE VIEW Producto_Categoria
	AS SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, 		EstNom
	FROM Producto, Categoria, Estado
	WHERE Producto.CatCod = Categoria.CatCod AND Producto.EstCod = Estado.EstCod
ORDER BY ProdNom;

-- Create instances section ------------------------------------------------- 

INSERT INTO Cargo VALUES (DEFAULT,"Administrador");
INSERT INTO Cargo VALUES (DEFAULT,"Empleado");

INSERT INTO Genero VALUES (DEFAULT,"Femenino");
INSERT INTO Genero VALUES (DEFAULT,"Masculino");

INSERT INTO Estado VALUES (DEFAULT,"Activo");
INSERT INTO Estado VALUES (DEFAULT,"Eliminado");

INSERT INTO Categoria VALUES (DEFAULT,"Varios"); 
INSERT INTO Categoria VALUES (DEFAULT,"Carnes"); 
INSERT INTO Categoria VALUES (DEFAULT,"Verduras"); 
INSERT INTO Categoria VALUES (DEFAULT,"Frutas"); 
INSERT INTO Categoria VALUES (DEFAULT,"Envasados"); 
INSERT INTO Categoria VALUES (DEFAULT,"Enlatados"); 

INSERT INTO Usuario VALUES (DEFAULT,"SVTA","SVTA","SVTA","SVTA","SVTA","SVTA",1,"SVTA",1,"SVTA","SVTA","SVTA","SVTA",1);
INSERT INTO Usuario VALUES (DEFAULT,"A","A","SVTA","SVTA","SVTA","SVTA",2,"SVTA",2,"SVTA","SVTA","SVTA","SVTA",1);

INSERT INTO Producto VALUES (DEFAULT,"Pera","La Fruta","bolsa 1K",6.80,60,4,1);
INSERT INTO Producto VALUES (DEFAULT,"Sandia","La Fruta","bolsa 1K",12.25,21,4,1);
INSERT INTO Producto VALUES (DEFAULT,"Aconcagua","Gloria","lata 200mL",2.65,52,6,1);
INSERT INTO Producto VALUES (DEFAULT,"Aconcagua","Gloria","lata 1L",5.64,52,6,1);
INSERT INTO Producto VALUES (DEFAULT,"Huevos","La Calera","6 uni.",6.92,12,2,1);
INSERT INTO Producto VALUES (DEFAULT,"Pan","Tentación","10 uni.",2.36,60,1,1);
INSERT INTO Producto VALUES (DEFAULT,"Tomates","La Fruta","bolsa 1K",5.12,32,3,1);
INSERT INTO Producto VALUES (DEFAULT,"Refresco","Perísimas","sobre de 3ml",0.96,20,1,1);
INSERT INTO Producto VALUES (DEFAULT,"Jugo","Gloria","botella 1L",2.36,30,5,1);
INSERT INTO Producto VALUES (DEFAULT,"Yogurt","Pura Vida","Botella 500mL",2.54,63,5,1);
INSERT INTO Producto VALUES (DEFAULT,"Papaya","La Fruta","bolsa 1 kilo",6.92,32,4,1);
INSERT INTO Producto VALUES (DEFAULT,"Galleta","Chomp","bolsa 6 uni.",6.6,60,1,1);
INSERT INTO Producto VALUES (DEFAULT,"Pera","Perísimas","bolsa 1 kilo",6.8,60,4,1);
INSERT INTO Producto VALUES (DEFAULT,"Yogurt","Soy Vida","botella 200mL",6.52,12,5,1);
INSERT INTO Producto VALUES (DEFAULT,"Papa","La Fruta","bolsa 1 kilo",4.21,6,4,1);
INSERT INTO Producto VALUES (DEFAULT,"Galleta","Casino","bolsa 12 uni.",1.23,5,1,1);
INSERT INTO Producto VALUES (DEFAULT,"Galleta","Tentación","bolsa 10 uni.",9.65,2,1,1);
INSERT INTO Producto VALUES (DEFAULT,"Galleta","Oreo","bolsa 2 uni.",4.21,2,1,1);
INSERT INTO Producto VALUES (DEFAULT,"Agua Mineral","Cielo","botella 100mL",3.21,21,5,1);
INSERT INTO Producto VALUES (DEFAULT,"Yogurt","Gloria","Botella 1L",0.80,6,5,1);



