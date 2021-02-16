Sample REST CRUD API with Spring Boot, Mysql, JPA and Hibernate



1. Clone the application
https://github.com/Abah-Yannick/HotelsandRoomsManagement.git

2. Create Mysql database `bash create database users_database 

3. Change mysql username and password as per your installation
•open src/main/resources/application.properties
•change spring.datasource.username and spring.datasource.password as per your mysql installation

4.run initScript.sql file present in the project.

5. Build and run the app using maven

Alternatively, you can run the app without packaging it using -
mvn spring-boot:run

The app will start running at http://localhost:8080.

Explore Rest APIs

The app defines following CRUD APIs.

### USER
GET /api/v1/users

POST /api/v1/users

GET /api/v1/users/{userId}

PUT /api/v1/users/{userId}

DELETE /api/v1/users/{userId}

### HOTEL

GET /api/v1/hotels

POST /api/v1/hotels

GET /api/v1/hotels/{hotelId}

PUT /api/v1/hotels/{hotelId}

DELETE /api/v1/hotels/{hotelId}

### ROOM

GET /api/v1/rooms

POST /api/v1/rooms

GET /api/v1/rooms/available  //TODO

GET /api/v1/rooms/{roomId}

PUT /api/v1/rooms/{roomId}

DELETE /api/v1/rooms/{roomId}


