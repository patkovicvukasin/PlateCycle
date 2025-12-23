# PlateCycle

PlateCycle is a microservice based application designed to enable food donation
and redistribution by allowing donors to offer surplus or near expiration food.
The system focuses on scalable backend architecture, service orchestration, and
secure communication between distributed services.

## Project Overview

PlateCycle connects food donors and users through a set of independent microservices.
The application allows:

- Donors to create food listings with details such as name, description, quantity,
  expiration date, and delivery availability.
- Users to browse available listings and reserve food items.
- Automatic coordination between services for reservations, quantity updates,
  and delivery handling.

The system is built using Spring Cloud technologies, with microservices communicating
via Feign clients and being dynamically discovered through a service registry.

## Architecture

The application consists of the following core components:

1. UserService  
2. ProductService  
3. ReservationsService  
4. PickupService  
5. API Gateway  
6. Naming Server  
7. Config Server  

All services are registered with the Eureka Naming Server.  
The API Gateway acts as a single entry point and handles request routing,
authentication, and authorization using JWT tokens.

Each microservice owns its own database, ensuring proper data isolation and
compliance with microservices best practices.

### Databases

- UserService → user_db  
- ProductService → product_db  
- ReservationsService → reservations_db  
- PickupService → pickup_db  

## Microservices Description

### UserService
- Handles user registration and authentication.
- Supports different user roles (donors and regular users).
- Stores user data in a dedicated PostgreSQL database.
- Provides domain-specific error handling (e.g. duplicate email, invalid credentials).

### ProductService
- Manages food listings created by donors.
- Provides CRUD operations for food products.
- Updates product quantities when reservations are made.

### ReservationsService
- Creates and manages reservations.
- Validates product availability via communication with ProductService.
- Coordinates with PickupService when delivery is required.
- Persists reservation data in its own database.

### PickupService
- Manages pickup and delivery information.
- Handles creation, update, and deletion of delivery records.

### API Gateway
- Serves as the main entry point for all client requests.
- Implements JWT-based authentication and authorization.
- Routes requests to appropriate microservices.

### Naming Server (Eureka)
- Provides service registration and discovery.
- Enables dynamic communication between microservices without hard-coded URLs.

### Config Server
- Provides centralized configuration management.
- Reads configuration files from an external Git repository.
- Keeps database credentials and environment-specific settings outside
  of individual service codebases and out of public repositories.

## Tech Stack

- Java 11  
- Spring Boot 2.3.12.RELEASE  
- Spring Cloud Hoxton.SR12  
- Spring Data JPA  
- Spring Security  
- OpenFeign  
- PostgreSQL  
- JWT  
- Docker & Docker Compose  
- Maven  

## Notes

This project was developed as an academic and showcase application.

