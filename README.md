Reserva Natural - API REST

Este proyecto es una API REST desarrollada en Java con Spring Boot para la gestión de animales en una reserva natural. Permite realizar operaciones CRUD sobre los animales registrados en la base de datos.

🚀 Tecnologías utilizadas

Java 17

Spring Boot (Web, JPA, Validation)

Spring Data JPA (con H2/MySQL como base de datos)

Maven (Gestor de dependencias)

Lombok (Para reducir código boilerplate)

Postman (Para pruebas de API)

📂 Estructura del Proyecto


![primera](https://github.com/user-attachments/assets/1a731c09-ea8d-4caf-b4a9-89ee6aafabee)

📌 Configuración de la Base de Datos

En el archivo application.properties configuramos la conexión a la base de datos:


![primera](https://github.com/user-attachments/assets/fc731c74-0ebd-4c08-834e-99d8470a535d)

Si prefieres usar una base de datos en memoria, puedes cambiar a H2:


![segunda](https://github.com/user-attachments/assets/191b1dc0-9d66-4f0e-8ce4-273054c2c011)

🛠 Funcionalidades Implementadas

1️⃣ CRUD de Animales

![primera](https://github.com/user-attachments/assets/f24e6231-5090-4759-b967-a23c178f22ff)

2️⃣ Filtrado por Familia

GET /api/animales/familia?familia={nombre} → Devuelve los animales que pertenecen a una familia específica.

🏗 Estructura del Código

📌 Modelo - Animal.java


![p1](https://github.com/user-attachments/assets/7ac92c27-7471-48a6-bf52-4d3a844f5b4c)

📌 Repositorio - AnimalRepository.java



![p2](https://github.com/user-attachments/assets/1696f992-69a0-45cb-b55e-a7ca4353c5ce)

📌 Servicio - AnimalService.java



![p1](https://github.com/user-attachments/assets/2757dc49-8eca-4e7b-8804-cb6dc269f563)

📌 Controlador - AnimalController.java

![p1](https://github.com/user-attachments/assets/b1d170b6-400b-44fa-ba6e-320b17fe96bf)

🔥 Cómo probar la API

1️⃣ Ejecutar la aplicación

Desde IntelliJ o con Maven:


![p1](https://github.com/user-attachments/assets/c0f7a256-e0b9-411a-867f-2acaa36ec0ed)

2️⃣ Pruebas con Postman

GET http://localhost:8080/api/animales

POST http://localhost:8080/api/animales (Enviar JSON en el body)

PUT http://localhost:8080/api/animales/{id} (Actualizar un animal)

DELETE http://localhost:8080/api/animales/{id}

GET http://localhost:8080/api/animales/familia?familia=Mamíferos




