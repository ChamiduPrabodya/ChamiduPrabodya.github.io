# Portfolio Backend

This is the backend service for Chamidu's portfolio website, built with Spring Boot and connected to MSSQL.

## Prerequisites

1. Java 17 or higher
2. Maven 3.6 or higher
3. MSSQL Server
4. IDE (IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

## Setup Instructions

### 1. Database Setup

First, create the database and tables using the SQL schema:

```sql
CREATE DATABASE PortfolioDB;
GO

USE PortfolioDB;
GO

CREATE TABLE ContactMessages (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Subject NVARCHAR(200),
    Message NVARCHAR(MAX) NOT NULL,
    CreatedDate DATETIME2 DEFAULT GETDATE(),
    IsRead BIT DEFAULT 0,
    ResponseSent BIT DEFAULT 0
);
GO
```

### 2. Configuration

Update the `src/main/resources/application.properties` file with your database credentials:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=PortfolioDB;encrypt=true;trustServerCertificate=true;
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build and Run

```bash
# Navigate to the backend directory
cd backend

# Build the project
mvn clean package

# Run the application
mvn spring-boot:run

# Or run the JAR file
java -jar target/portfolio-backend-0.0.1-SNAPSHOT.jar
```

## API Endpoints

- `POST /api/contact` - Submit contact form
- `GET /api/contact` - Get all contact messages (for admin panel)

## Deployment

To deploy to a production environment:

1. Update the CORS configuration in `ContactController.java` to allow your production domain
2. Update the database connection details in `application.properties`
3. Build the JAR file: `mvn clean package`
4. Deploy the JAR file to your server
5. Run with: `java -jar portfolio-backend-0.0.1-SNAPSHOT.jar`

## Frontend Integration

The frontend JavaScript is configured to communicate with the backend at `http://localhost:8080`. When deploying, update the URL in `assets/js/main.js` to point to your deployed backend.