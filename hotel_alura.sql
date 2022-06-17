CREATE DATABASE IF NOT EXISTS hotel_alura;

USE hotel_alura;


CREATE TABLE IF NOT EXISTS reservas(
id INT NOT NULL AUTO_INCREMENT,
fecha_entrada DATE NOT NULL,
fecha_salida DATE NOT NULL,
valor NUMERIC(10),
forma_pago INT NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_forma_pago_categoria_id
FOREIGN KEY(forma_pago)
REFERENCES formas_de_pago(id) 
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS huespedes(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
	fecha_de_nacimiento DATE NOT NULL,
    nacionalidad VARCHAR(30) NOT NULL,
    telefono VARCHAR (20) NOT NULL,
    id_reserva INT NOT NULL,
    CONSTRAINT fk_huesped_reserva
    FOREIGN KEY(id_reserva)
    REFERENCES reservas(id),
    PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS users(
user_id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
pass VARCHAR(20) NOT NULL,
PRIMARY KEY (user_id)
)ENGINE=INNODB;
			
CREATE TABLE if not EXISTS formas_de_pago(
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    PRIMARY KEY (id) 
)ENGINE = INNODB;

insert into reservas(
fecha_entrada,
fecha_salida,
valor,
forma_pago
)values(
'2022-8-1',
'2022-8-9',
'60000',
3
);

insert into huespedes(
nombre,
apellido,
fecha_de_nacimiento,
nacionalidad,
telefono,
id_reserva
) values(

'Rodrigo',
'Leon',
'1990-3-10',
'Uruguay',
'1135789345',
2
);

INSERT INTO formas_de_pago(
	nombre)VALUES('Dinero en Efectivo');

INSERT INTO users (username, pass) values('nuccelli','Nuccelli123');

ALTER TABLE huespedes AUTO_INCREMENT = 1;
ALTER TABLE reservas AUTO_INCREMENT = 1;
select * from huespedes;
select * from reservas;
select * from formas_de_pago;
select USERNAME, PASS from users;
drop table huespedes;
drop table reservas;  
DELETE from huespedes;
DELETE from reservas;

