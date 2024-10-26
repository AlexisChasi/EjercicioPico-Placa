FRONT END AUTOS

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


## Configuración

### Configuración de la Base de Datos

Asegúrate de tener PostgreSQL instalado y en ejecución. Crea una base de datos llamada `crud` y ajusta el archivo `application.properties` en `src/main/resources` con la siguiente configuración:

```properties
spring.application.name=crud
spring.datasource.url=jdbc:postgresql://localhost:5432/crud
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
frontend.url=http://localhost:4200/
```
# PARA EJECUTAR EL PROYECTO CLONAR ESTE REPOSITORIO Y EJECUTAR EL PROGRAMA

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
# Obtener Todos los Vehículos
- URL: /car
- Método: GET
- Respuesta: Lista de vehículos en formato JSON.
- Obtener un Vehículo por ID
- URL: /car/{id}
- Método: GET
- Respuesta: Vehículo en formato JSON o 404 si no se encuentra.

# Actualizar un Vehículo
- URL: /car
- Método: PUT
- Body:
```
{
  "id": 1,
  "licensePlate": "ABC1234",
  "color": "Azul",
  "model": "Sedan",
  "chassis": "CH123457",
  "owner": "Juan Ortiz"
}
```

# Eliminar un Vehículo
- URL: /car/{id}
- Método: DELETE
- Respuesta: 200 si se elimina correctamente o 404 si no se encuentra.

# Verificar Circulación
# URL: /car/check-circulation
# Método: GET
# Query Parameters:
# licensePlate: Placa del vehículo.
# fechaConsulta: Fecha y hora de la consulta en formato yyyy-MM-dd'T'HH:mm:ss.
# Ejemplo de Respuesta
```
{
  "message": "El vehículo con la placa ABC1234 NO puede circular hoy (Lunes) de 7:00 a 9:30 o de 16:00 a 19:00."
}
```
