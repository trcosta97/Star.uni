# Star.uni: A Comprehensive School Management System

Star.uni is a full-stack application designed to manage student and teacher information for educational institutions.

The system provides a robust backend API built with Spring Boot and a user-friendly frontend interface developed using React. It offers functionalities for user authentication, student and teacher registration, and data management.

## Repository Structure

```
.
├── api
│   └── api
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       └── src
│           ├── main
│           │   ├── java
│           │   │   └── star
│           │   │       └── uni
│           │   │           └── api
│           │   │               ├── ApiApplication.java
│           │   │               ├── controller
│           │   │               ├── domain
│           │   │               └── infra
│           │   └── resources
│           │       ├── application.properties
│           │       └── db
│           │           └── migration
│           └── test
│               └── java
│                   └── star
│                       └── uni
│                           └── api
│                               └── ApiApplicationTests.java
├── front
│   └── unistar_front
│       ├── package.json
│       ├── public
│       │   ├── index.html
│       │   ├── manifest.json
│       │   └── robots.txt
│       ├── README.md
│       └── src
│           ├── App.js
│           ├── Components
│           │   ├── Alunos
│           │   ├── Banner
│           │   ├── Botao
│           │   ├── BotaoLink
│           │   ├── BotaoLogin
│           │   ├── CampoTexto
│           │   ├── Dropdown
│           │   ├── FormularioAluno
│           │   ├── FormularioProfessor
│           │   ├── Home
│           │   └── Login
│           └── index.js
└── README.md
```

Key Files:
- `api/api/src/main/java/star/uni/api/ApiApplication.java`: Main entry point for the Spring Boot application
- `api/api/pom.xml`: Maven configuration file for the backend
- `front/unistar_front/package.json`: npm configuration file for the frontend
- `front/unistar_front/src/index.js`: Main entry point for the React application

## Usage Instructions

### Installation

Prerequisites:
- Java 17
- Node.js (latest LTS version)
- MySQL 8.0

Backend Setup:
1. Navigate to the `api/api` directory
2. Run `mvn clean install` to build the project
3. Run `mvn spring-boot:run` to start the backend server

Frontend Setup:
1. Navigate to the `front/unistar_front` directory
2. Run `npm install` to install dependencies
3. Run `npm start` to start the development server

### Configuration

Backend:
1. Configure the database connection in `api/api/src/main/resources/application.properties`
2. Set the JWT secret in the same file

Frontend:
1. Update the API base URL in `front/unistar_front/src/axios.js` if necessary

### Getting Started

1. Access the frontend application at `http://localhost:3000`
2. Log in using the provided credentials
3. Use the navigation menu to access different features:
   - Register new students
   - Register new teachers
   - View registered students

### Common Use Cases

1. Registering a new student:
   - Navigate to the student registration page
   - Fill in the required fields (name, email, CPF, class, address)
   - Click "Cadastrar" to submit the form

2. Registering a new teacher:
   - Navigate to the teacher registration page
   - Fill in the required fields (name, email, CPF, discipline, address)
   - Click "Cadastrar" to submit the form

3. Viewing registered students:
   - Navigate to the students list page
   - The system will display a paginated list of all active students

### Integration Patterns

The frontend communicates with the backend using RESTful API calls. Authentication is handled using JWT tokens, which are included in the `Authorization` header of each request.

### Testing & Quality

To run backend tests:
```
cd api/api
mvn test
```

To run frontend tests:
```
cd front/unistar_front
npm test
```

### Troubleshooting

1. Issue: Unable to connect to the database
   - Ensure MySQL is running and accessible
   - Check the database configuration in `application.properties`
   - Verify that the database exists and the user has proper permissions

2. Issue: JWT authentication fails
   - Check that the JWT secret is correctly set in `application.properties`
   - Ensure that the token is being sent in the `Authorization` header
   - Verify that the token has not expired

3. Issue: Frontend fails to communicate with the backend
   - Check that both frontend and backend servers are running
   - Verify that the API base URL is correctly set in the frontend
   - Check for any CORS issues in the browser's developer console

## Data Flow

The Star.uni application follows a typical client-server architecture. Here's an overview of the data flow:

1. User interacts with the React frontend
2. Frontend sends HTTP requests to the Spring Boot backend API
3. Backend processes the request, interacts with the MySQL database if necessary
4. Backend sends a response back to the frontend
5. Frontend updates the UI based on the received data

```
[User] <-> [React Frontend] <-> [Spring Boot API] <-> [MySQL Database]
```

Important technical considerations:
- JWT is used for authentication between frontend and backend
- API endpoints are secured using Spring Security
- Database migrations are managed using Flyway

## Deployment

Prerequisites:
- Java 17 runtime
- Node.js runtime
- MySQL 8.0 database server

Deployment steps:
1. Build the backend:
   ```
   cd api/api
   mvn clean package
   ```
2. Build the frontend:
   ```
   cd front/unistar_front
   npm run build
   ```
3. Deploy the backend JAR file to your server
4. Deploy the frontend build files to a static file server
5. Configure the database and update the backend's `application.properties`
6. Start the backend application

Environment configurations:
- Set the `SPRING_PROFILES_ACTIVE` environment variable to `prod`
- Ensure the JWT secret is securely set in production

Monitoring setup:
- Implement logging using a centralized logging system
- Set up application performance monitoring (APM) for both frontend and backend