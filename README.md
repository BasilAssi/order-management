# order-management
![image](https://github.com/BasilAssi/order-management/assets/104434508/085775b5-e0d9-4478-9ae4-4ec09bfe6858)

Order Management
This repository contains a Spring Boot application that manages orders based on the provided database schema. 
The project includes a Docker configuration for easy setup and deployment. The API endpoints have been secured and Swagger documentation is available.

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

Java 19

Maven

Docker

Postman

Clone the Repository
To clone the repository and navigate into the directory, run the following commands:

git clone https://github.com/BasilAssi/order-management.git
cd order-management



Postman Collection

You can find the Postman collection for API testing in the repository. Download it and import into your Postman application for local testing.

API Documentation

You can find the API documentation at http://localhost:8080/swagger-ui.html when the application is running. The documentation includes information about all endpoints, models, and authentication.

Security

This application uses JWT for securing the APIs. To get the token, use the /api/authenticate endpoint with the correct username and password.
Include the token in the Authorization header with the prefix "Bearer " in all requests.

Code Documentation

The source code is documented following Java best practices, which means each method, class, and module includes comments and descriptions of their functionality.

Contributing

