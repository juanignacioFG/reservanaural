CREATE TABLE animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    familia VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    pais_origen VARCHAR(255) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    imagen VARCHAR(255)
);