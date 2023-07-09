# order-management
![Screenshot 2023-07-05 231437](https://github.com/BasilAssi/order-management/assets/104434508/980a6c2d-3263-4b49-bbe5-9f1e4696cd1b)

Order Management
This repository contains a Spring Boot application that manages orders based on the provided database schema. 
The project includes a Docker configuration for easy setup and deployment. The API endpoints have been secured and Swagger documentation is available.

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

Java 17

Maven

Docker

Postman

Clone the Repository
To clone the repository and navigate into the directory, run the following commands:

git clone https://github.com/BasilAssi/order-management.git
cd order-management

Building the Application

To compile the source code, package the compiled code into a JAR file, and install the packaged code in your local repository:

mvn clean install

Creating and Running the Docker Image

To create a Docker image for the application, ensure Docker is running and execute:

docker build -t order-management-app .

This will build a Docker image named order-management-app.

To run the application in a Docker container:

docker run -p 8080:8080 order-management-app

The application will be accessible at http://localhost:8080.

Postman Collection

You can find the Postman collection for API testing in the repository. Download it and import into your Postman application for local testing.

API Documentation

You can find the API documentation at http://localhost:8080/swagger-ui.html when the application is running. The documentation includes information about all endpoints, models, and authentication.

Security

This application uses JWT for securing the APIs. To get the token, use the /api/authenticate endpoint with the correct username and password.
Include the token in the Authorization header with the prefix "Bearer " in all requests.

Code Documentation

The source code is documented following Java best practices, which means each method, class, and module includes comments and descriptions of their functionality.

Setup the Application
-create a database named "order-management".
-deploy the application
-mvn clean
-mvn install -DskipTests
-Build the docker image
-docker build -t order_management .
-run the docker image:
-docker run -p 8080:8080 -e SPRING_DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/order-management?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull" -e SPRING_DATASOURCE_USERNAME=<your_username> -e SPRING_DATASOURCE_PASSWORD=<your_password> my-spring-app


