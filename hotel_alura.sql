CREATE DATABASE IF NOT EXISTS hotel_alura;

USE hotel_alura;

CREATE TABLE IF NOT EXISTS huespedes(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
	fecha_de_nacimiento DATE NOT NULL,
    nacionalidad VARCHAR(30) NOT NULL,
    telefono VARCHAR (20) NOT NULL,
    id_reserva INT NOT NULL,
    PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS reservas(
id INT NOT NULL AUTO_INCREMENT,
fecha_entrada VARCHAR(20) NOT NULL,
fecha_salida VARCHAR(20) NOT NULL,
valor NUMERIC(10),
forma_pago INT NOT NULL,
PRIMARY KEY(id) 
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS users(
user_id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
pass VARCHAR(20) NOT NULL,
PRIMARY KEY (user_id)
)ENGINE=INNODB;
			
CREATE TABLE if not EXISTS formas_de_pago(
	id INT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    PRIMARY KEY (id) 
)ENGINE = INNODB;

CREATE TABLE if not EXISTS valor(
id INT NOT NULL,
valor NUMERIC(15) NOT NULL,
PRIMARY KEY (id) 
)ENGINE = INNODB;
ALTER TABLE huespedes ADD CONSTRAINT fk_huesped_reserva FOREIGN KEY(id_reserva) REFERENCES reservas(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE reservas ADD CONSTRAINT fk_forma_pago_categoria_id FOREIGN KEY(forma_pago) REFERENCES formas_de_pago(id);
INSERT INTO formas_de_pago(id, nombre)VALUES(1,'Tarjeta de Crédito'),(2,'Tarjeta de Débito'),(3,'Dinero en Efectivo');
INSERT INTO valor(id, valor) VALUES(1, 7500);
INSERT INTO users (username, pass) values('alurahotel','Alura2022');