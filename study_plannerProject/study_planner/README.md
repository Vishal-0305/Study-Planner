# 📚 Study Planner

A simple web application for creating, tracking, and managing study tasks — built with **Spring Boot**, **Thymeleaf**, and **SQLite**.

Add tasks with a title, description, and due date, and the app automatically shows a live countdown ("time remaining") for each one, so you always know what's coming up next.

## Features

- ➕ Add, edit, and delete study tasks
- 🗓️ Set a due date for each task
- ⏳ Automatic "time remaining" countdown (days / hours / minutes left, or "Overdue")
- 🌙 Dark mode toggle (saved in the browser)
- 💾 Lightweight persistence with an embedded SQLite database — no external database setup required

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.5.3 |
| Web / Templating | Spring Web MVC + Thymeleaf |
| Persistence | Spring Data JPA + Hibernate |
| Database | SQLite (via `sqlite-jdbc` and `hibernate-community-dialects`) |
| Build Tool | Maven |

## Project Structure

```
study_planner/
├── src/
│   ├── main/
│   │   ├── java/com/example/study_planner/
│   │   │   ├── StudyPlannerApplication.java   # App entry point
│   │   │   ├── Task.java                      # Task entity (title, description, dueDate, timeRemaining)
│   │   │   ├── TaskController.java             # Routes for list/add/edit/delete
│   │   │   └── TaskRepository.java             # Spring Data JPA repository
│   │   └── resources/
│   │       ├── templates/                     # Thymeleaf views (index.html, form.html)
│   │       ├── static/                        # CSS and images
│   │       └── application.properties          # App & datasource configuration
│   └── test/                                   # Application tests
├── pom.xml                                     # Maven build configuration
└── study-planner.db                            # SQLite database file (auto-created)
```

## Getting Started

### Prerequisites

- [Java 21](https://adoptium.net/) or later
- Maven (or use the included Maven Wrapper — no separate install needed)

### Run the application

Clone the repository and start the app using the Maven Wrapper:

```bash
git clone https://github.com/Vishal-0305/Study-Planner.git
cd Study-Planner/study_plannerProject/study_planner

# On macOS/Linux
./mvnw spring-boot:run

# On Windows
mvnw.cmd spring-boot:run
```

The application will start on **http://localhost:8080** by default.

### Build a JAR

```bash
./mvnw clean package
java -jar target/study-planner-0.0.1-SNAPSHOT.jar
```

## Configuration

The app uses an embedded SQLite database defined in `src/main/resources/application.properties`:

```properties
spring.application.name=study-planner
spring.datasource.url=jdbc:sqlite:study-planner.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
spring.thymeleaf.cache=false
```

The database file (`study-planner.db`) is created automatically in the project directory on first run — no manual setup required.

## Usage

1. Open `http://localhost:8080` in your browser to see your task list.
2. Click **➕ Add Task** to create a new study task with a title, description, and due date.
3. Each task shows a live "time remaining" indicator.
4. Use **Edit** or **Delete** next to any task to update or remove it.
5. Toggle **🌙 Toggle Dark Mode** for a dark theme.

## Routes

| Method | Path | Description |
|---|---|---|
| GET | `/` | View all tasks |
| GET | `/add` | Show the "add task" form |
| POST | `/save` | Save a new or edited task |
| GET | `/edit/{id}` | Show the edit form for a task |
| GET | `/delete/{id}` | Delete a task |

## Contributing

Contributions are welcome! Feel free to fork the repository, make changes, and open a pull request.

## License

No license has been specified for this project yet.
