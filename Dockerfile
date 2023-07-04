From openjdk:19
EXPOSE 8080
ADD target/WebServciesFinalProject-0.0.1-SNAPSHOT.jar order-management.jar
ENTRYPOINT ["java","-jar","order-management.jar"]