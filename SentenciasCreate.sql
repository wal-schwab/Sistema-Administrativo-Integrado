CREATE DATABASE sai;

USE sai;

CREATE TABLE roles (
	idRol INT NOT NULL AUTO_INCREMENT, 
	nombreRol VARCHAR(25) NOT NULL,
    descripcion VARCHAR(200),
	PRIMARY KEY (idRol)
);

    CREATE TABLE centrosDeCostos (
    idCentro INT PRIMARY KEY NOT NULL, -- ID de 12 números 
    nombreCentro VARCHAR(50) NOT NULL, -- Áreas de una empresa relacionadas a una dirección
    direccion VARCHAR(30) NOT NULL -- Puede ser ADMINISTRATIVA, COMERCIAL, RRHH, OPERACIONES o MARKETING 
);

CREATE TABLE proovedores (
    idProveedor INT PRIMARY KEY NOT NULL, -- ID de 8 dígitos
    nombreProveedor VARCHAR(25) NOT NULL,
    nombreContacto VARCHAR(25) ,
    email VARCHAR(75),
    actividadPrincipal VARCHAR(50) NOT NULL -- Relacionado con venta o servicios de sistemas
);

CREATE TABLE presupuestos (
    idPresupuesto INT PRIMARY KEY NOT NULL, -- ID de cuatro numeros
    periodo INT NOT NULL,
    estado VARCHAR(15) -- CONFIRMADO / EN REVISIÓN
);

CREATE TABLE items(
	idItem INT PRIMARY KEY NOT NULL, -- ID de 11 números 
    nombreItem VARCHAR(100) NOT NULL, 
    tipoItem VARCHAR(50) -- BIEN O SERVICIO
);

CREATE TABLE usuarios(
	legajo INT NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    contrasena VARCHAR(16) NOT NULL,
	idRol INT NOT NULL,
	
    PRIMARY KEY(legajo),
    FOREIGN KEY (idRol) REFERENCES roles(idRol)
);

CREATE TABLE gastos (
    idGasto INT PRIMARY KEY NOT NULL,
    fechaEmision DATETIME DEFAULT CURRENT_TIMESTAMP,
    fechaRecepcion DATE,
    estado VARCHAR(15) NOT NULL, -- RECEPCIONADO / EMITIDO
    nroFactura INT,
    tipoGasto VARCHAR(25), -- RUN THE BUSINESS, GROWTH THE BUSINESS, TRANSFORM THE BUSINESS
    idProveedor INT NOT NULL,
    idCentro INT NOT NULL,
    importe DOUBLE NOT NULL,

    FOREIGN KEY (idProveedor) REFERENCES proovedores(idProveedor),
    FOREIGN KEY (idCentro) REFERENCES centrosDeCostos(idCentro)
);

CREATE TABLE notas(
	idNota INT PRIMARY KEY NOT NULL,
    idGasto INT NOT NULL,
    tipoNota VARCHAR(10) NOT NULL, -- DÉBITO o CRÉDITO
    importe DOUBLE NOT NULL,
    
    FOREIGN KEY (idGasto) REFERENCES gastos(idGasto)
);
    
CREATE TABLE gastosPresupuestados (
    idGastoPresupuestado INT PRIMARY KEY NOT NULL,
    idProveedor INT , -- Puede poseer la leyenda "A DEFINIR"
    idPresupuesto INT NOT NULL,
    idCentro INT NOT NULL,
    gastoAsociado INT, -- Cuando se realize un gasto relacionado al gastoPresupuestado
    importe DOUBLE NOT NULL,

    FOREIGN KEY (idProveedor) REFERENCES proovedores(idProveedor),
    FOREIGN KEY (idCentro) REFERENCES centrosDeCostos(idCentro),
    FOREIGN KEY (gastoAsociado) REFERENCES gastos(idGasto),
    FOREIGN KEY (idPresupuesto) REFERENCES presupuestos(idPresupuesto)
);

CREATE TABLE gasto_item (
    idGasto INT NOT NULL,
    idItem INT NOT NULL,
    cantidad int,
    PRIMARY KEY (idGasto, idItem),
    
    FOREIGN KEY (idGasto) REFERENCES gastos(idGasto),
    FOREIGN KEY (idItem) REFERENCES items(idItem)
);



