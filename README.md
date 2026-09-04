# Pet Service - Pet Clinic Microservices

## 👤 Student & Project Metadata

- **Student Name**: Oshadha Sankalpa Thambavita
- **Student Number**: 241711043
- **Slack Handle**: Oshadha Thambavita
- **GCP ID**: eca-petclinic-241711043

Microservice managing pet patients, medical history, and owner records for the Pet Clinic application, built with **Spring Boot 3.4.3**, **Spring Data MongoDB**, **MongoDB**, **Lombok**, and **Java 25**.

## Architecture & Features

- **Entity-DTO Pattern**: Strict separation between MongoDB document schema (`Pet`) and API Data Transfer Objects (`PetRequestDto`, `PetResponseDto`).
- **Lombok Integration**: Uses `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, and `@Builder` annotations.
- **NoSQL Document Store**: Flexible document storage in MongoDB (`pets` collection).

## Database & Port

- **Port**: `8082`
- **Database**: MongoDB (`localhost:13500/petdb`)

## REST API Endpoints

| Method | Endpoint | Description | Payload |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/pets` | Get all pet patient DTOs | N/A |
| `GET` | `/api/pets/{id}` | Get pet patient DTO by ID | N/A |
| `POST` | `/api/pets` | Register new pet patient | `PetRequestDto` JSON |
| `DELETE` | `/api/pets/{id}` | Delete pet record | N/A |

## How to Run

```bash
mvn clean spring-boot:run
```
