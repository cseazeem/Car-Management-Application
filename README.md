Car Management Application
Description
The Car Management Application is a RESTful API built with Spring Boot that allows users to manage car information. Users can sign up, log in, and perform CRUD operations on cars, including adding up to 10 images per car. It features user authentication with JWT and leverages PostgreSQL for database storage, Liquibase for migrations, and JDBI for database interaction.


Features
User Authentication: Secure signup and login using JWT.
CRUD Operations: Create, view, update, and delete car entries.
Image Support: Upload up to 10 images per car.
Search Functionality: Perform global search across cars based on title, description, or tags.
Ownership Control: Users can only manage their own cars.
API Documentation: Swagger documentation available at /api/docs.


Tech Stack
Backend: Spring Boot
Database: PostgreSQL
Database Migrations: Liquibase
Database Access: JDBI
Authentication: JWT (JSON Web Tokens)
Other Tools: Lombok for reducing boilerplate code.


Tech Stack
Backend: Spring Boot
Database: PostgreSQL
Database Migrations: Liquibase
Database Access: JDBI
Authentication: JWT (JSON Web Tokens)
Other Tools: Lombok for reducing boilerplate code.

git clone [https://github.com/your-username/car-management.git](https://github.com/cseazeem/Car-Management-Application.git)
cd car-management


Configure the database:

Create a PostgreSQL database (e.g., car_management_db).
Update the src/main/resources/application.properties file with your database credentials:


spring.datasource.url=jdbc:postgresql://localhost:5432/car_management_db
spring.datasource.username=root
spring.datasource.password=root


Run the application:
mvn spring-boot:run

Access the application:

APIs are available at http://localhost:8080.
API documentation is available at http://localhost:8080/api/docs.

Deployment
Deploy to Heroku (or any cloud platform):

Add your database and environment variables.
Run the application as a JAR file.
Example Deployment Command:

java -jar target/car-management-0.0.1-SNAPSHOT.jar


Future Improvements
Add image storage using AWS S3 or local filesystem.
Enhance search functionality with filters (e.g., car type, company, dealer).
Implement role-based access control (RBAC).
Frontend integration with React/Angular.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Contact
For any inquiries or feedback, please reach out to cseazeem@gmail.com







