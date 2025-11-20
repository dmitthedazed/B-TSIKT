# Collaborative Study Platform

A backend application designed for students to collaborate in study groups, manage tasks, share resources, and track progress in real-time.

## Features

- **Authentication & Authorization**: 
  - Secure registration and login using Spring Security (Session-based).
  - Password encryption with BCrypt.
- **Group Management**: 
  - Create study groups.
  - Add members to groups.
- **Task Management**: 
  - Create tasks within groups.
  - Set deadlines and update task status (TODO, IN_PROGRESS, DONE).
- **Resource Sharing**: 
  - Upload files (PDFs, images, etc.) to specific groups.
  - Download shared resources.
  - Files are stored locally in the `uploads/` directory.
- **Real-time Notifications**: 
  - WebSocket integration (STOMP) to notify group members about new tasks, files, or members.
- **Analytics & Logging**: 
  - Track user activity (Activity Logs).
  - View group statistics (Task completion rates).

## Tech Stack

- **Language**: Java 21
- **Framework**: Spring Boot 3.2.3
- **Database**: SQLite (with Hibernate dialect)
- **Security**: Spring Security
- **Real-time**: Spring WebSocket (STOMP)
- **Testing**: JUnit 5, Mockito, MockMvc

## Project Structure

```
Semestralne_Zadanie/
├── src/
│   ├── main/java/com/example/studyplatform/
│   │   ├── config/       # Security & WebSocket configuration
│   │   ├── controller/   # REST Controllers (API endpoints)
│   │   ├── model/        # JPA Entities (User, Group, Task, etc.)
│   │   ├── repository/   # Spring Data JPA Repositories
│   │   └── service/      # Business Logic
│   └── test/             # Unit and Integration Tests
├── uploads/              # Directory for uploaded files
├── study-platform.db     # SQLite database file (auto-generated)
├── pom.xml               # Maven dependencies
└── test_api.http         # HTTP requests for testing the API
```

## How to Run

1. **Prerequisites**: Ensure you have Java 21 installed.
2. **Build & Run**:
   Open a terminal in the project root and run:
   ```bash
   ./mvnw spring-boot:run
   ```
   (Or use the "Run" button in your IDE).

3. **Access**: The server will start at `http://localhost:8080`.

## API Usage

You can test the API using the provided `test_api.http` file in VS Code (requires REST Client extension) or use Postman.

### Key Endpoints:

- **Auth**:
  - `POST /api/auth/register` - Register a new user.
  - `POST /api/auth/login` - Login (returns JSESSIONID).

- **Groups**:
  - `POST /api/groups` - Create a group.
  - `POST /api/groups/{id}/members` - Add a member.

- **Tasks**:
  - `POST /api/groups/{id}/tasks` - Create a task.
  - `PUT /api/tasks/{id}/status` - Update task status.

- **Resources**:
  - `POST /api/groups/{id}/resources` - Upload a file (Multipart).
  - `GET /api/resources/{filename}` - Download a file.

- **Stats**:
  - `GET /api/stats/groups/{id}` - Get group statistics.
