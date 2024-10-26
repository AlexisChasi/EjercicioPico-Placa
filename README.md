### FRONT END AUTOS

## Descripción

Este es un proyecto de backend desarrollado en Java utilizando Spring Boot. Proporciona una API REST para gestionar vehículos, permitiendo operaciones de creación, lectura, actualización y eliminación (CRUD) de registros de vehículos. También incluye un servicio para verificar si un vehículo puede circular basado en su placa y la fecha de consulta.

## Tecnologías

- **Java 17**
- **Spring Boot** 3.3.4
- **PostgreSQL** como base de datos
- **Maven** como gestor de dependencias

## Requisitos

- JDK 17 
- PostgreSQL
- Maven
- crear la bd en PostgreSQL y establecer la contraseña 123456 
- abrir el proyecto en Intellij

![image](https://github.com/user-attachments/assets/5d650514-5039-4b61-b821-10f29ed538f4)


## Configuración

### Configuración de la Base de Datos

Asegúrate de tener PostgreSQL instalado y en ejecución. Crea una base de datos llamada `crud` y ajusta el archivo `application.properties` en `src/main/resources` con la siguiente configuración:

```properties
spring.application.name=crud
spring.datasource.url=jdbc:postgresql://localhost:5432/crud
spring.datasource.username=postgres
spring.datasource.password=123456 o la contraseña especificada
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
frontend.url=http://localhost:4200/
```
# PARA EJECUTAR EL PROYECTO CLONAR ESTE REPOSITORIO Y EJECUTAR EL PROGRAMA

![image](https://github.com/user-attachments/assets/f98da765-5c59-4017-8195-fc3ec5617bd7)


# PROBAR METODOS EN POSTMAN
- Endpoints
- Crear un Vehículo
- URL: /car
- Método: POST
- Body:
```
{
  "licensePlate": "ABC1234",
  "color": "Rojo",
  "model": "Sedan",
  "chassis": "CH123456",
  "owner": "Juan Pérez"
}
```

![image](https://github.com/user-attachments/assets/8c108ec6-f13f-4578-bf43-b716fdf1636b)

# Obtener Todos los Vehículos
- URL: /car
- Método: GET
- Respuesta: Lista de vehículos en formato JSON.
  
![image](https://github.com/user-attachments/assets/4ac5236b-a6e7-4b0c-9aad-f0df4a2aaffd)

# Obtener un Vehículo por ID
- URL: /car/{id}
- Método: GET
- Respuesta: Vehículo en formato JSON o 404 si no se encuentra.
  
![image](https://github.com/user-attachments/assets/fbee5648-9fe8-4482-a700-a39724fa9719)

# Actualizar un Vehículo
- URL: /car
- Método: PUT
- Body:
```
{
 "id": 1,
 "licensePlate": "ABC1234",
 "color": "Azul",
"model": "Toyota Corolla",
"chassis": "XYZ12345ABC",
"owner": "Alexis Chasi"
 }
```
![image](https://github.com/user-attachments/assets/b637ff49-0860-4a84-acbf-d7c58536e4ee)


# Eliminar un Vehículo
- URL: /car/{id}
- Método: DELETE
- Respuesta: 200 si se elimina correctamente o 404 si no se encuentra.

  ![image](https://github.com/user-attachments/assets/12d28d56-e0a2-4468-8575-969f50237bd5)

# Verificar Circulación
- URL: /car/check-circulation
- Método: GET
- Query Parameters:
- licensePlate: Placa del vehículo.
- fechaConsulta: Fecha y hora de la consulta en formato yyyy-MM-dd'T'HH:mm:ss.
- Ejemplo de Respuesta
```
{
  "message": "El vehículo con la placa ABC1234 NO puede circular hoy (Lunes) de 7:00 a 9:30 o de 16:00 a 19:00."
}
```
![image](https://github.com/user-attachments/assets/be30a50e-d561-4a80-b446-e33ffb642d28)
