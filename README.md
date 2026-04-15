# CLI Agenda

Console-based agenda application developed in **Java 21** for managing events and notes. The project implements **SQL database persistence**, layered architecture, feature-based organization, Docker execution, and **JUnit 5** testing.

Project developed as a final team assignment applying best practices in design, modularity, and separation of concerns.

## Features

### Event Management
- Create, list, update, and delete events
- Validation for title, location, and dates (start/end)

### Note Management
- Create, list, update, and delete notes
- Text-based content organization

## Technical Features
- **Layered architecture**: Clear separation between UI, Service, and Data layers.
- **Feature-based organization**: logical grouping by `event` and `note` modules.
- **Repository pattern**: Abstraction of the data access layer.
- **Design Patterns**: 
    - **Singleton**: Ensures a single instance of the database connection (`MySQLConnection`) is reused throughout the application.
    - **Builder**: Implemented in the `Event` class for safe, structured object creation with validation.
    - **Repository**: Abstracts the persistence layer using interfaces (`NoteRepository`, `EventRepository`). This separates the business logic from the specific database implementation, making the code more maintainable and easier to test via mocks.
- **Custom exception handling**: Validation of business rules (e.g., date ranges).
- **CLI application**: Interactive menus for seamless user experience.
- **Database in Docker container**: Reproducible environment using Docker Compose.
- **SQL database persistence**: Robust data storage using JDBC and MySQL.
- **Maven-managed project**: Automated dependency and build management.

## Technologies Used

| Technology | Purpose |
| :--- | :--- |
| **Java 21** | Business logic and core functionality |
| **Maven** | Project management and build automation |
| **SQL (MySQL)** | Structured data persistence |
| **Docker** | Containerization for the database environment |
| **JUnit 5** | Unit and integration testing |
| **Mockito** | Mocking dependencies for service testing |

## Prerequisites
Before running the project, ensure you have installed:
- **Java 21** or higher
- **Maven** (for dependency management and compilation)
- **Docker** and **Docker Compose** (for the database)
- **Git** (to clone the repository)

## Installation and Execution Instructions

### 1. Clone the repository
```bash
git clone https://github.com/carlasalmeron/S3.04-Developers-Team.git
```

### 2. Configure the database with Docker
Configure the MySQL infrastructure using Docker to ensure a unified local environment.
1. Open a terminal in the project root folder.
2. Run `docker-compose up -d`.
3. Verify that the MySQL container is running.

### 3. Compile the project with Maven
```bash
mvn clean compile
```

### 4. Run the application
```bash
mvn exec:java -Dexec.mainClass="com.agenda.application.AgendaApp"
```

### 5. Run tests
```bash
mvn test
```

### 6. Stop the database
```bash
docker-compose down
```

## Project Structure
```text
S3.04-Developers-Team/
├── .gitignore
├── docker-compose.yml
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── agenda/
    │               ├── application/
    │               │   └── menu/
    │               ├── common/
    │               │   └── utils/
    │               ├── event/
    │               │   ├── model/
    │               │   ├── repository/
    │               │   └── service/
    │               ├── note/
    │               │   ├── model/
    │               │   ├── repository/
    │               │   └── service/
    │               └── infrastructure/
    │                   └── sql/
    └── test/
        └── java/
            └── com/
                └── agenda/
                    ├── event/
                    └── note/
```

## Database Schema

### Notes Table:
- `id` (INT - PK)
- `title` (VARCHAR - required)
- `content` (TEXT - optional)

### Events Table:
- `id` (INT - PK)
- `title` (VARCHAR - required)
- `location` (VARCHAR - optional)
- `start_date` (DATETIME - required)
- `end_date` (DATETIME - required)

## Authors
Project developed by:
- **Carla Salmeron**
- **Marc Casadevall**
