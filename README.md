# Task Management System – Oritso Assignment

---

## 1. Introduction

### 1.1 Purpose

The purpose of this project is to implement a **Task Management System** that demonstrates the ability to design and develop a **full-stack application using MVC architecture**.

The system allows users to:

- Create tasks
- View tasks
- Update tasks
- Delete tasks
- Search tasks

---

## 2. Technology Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- REST API

### Frontend
- HTML
- JavaScript
- Bootstrap

### Database
- MySQL

### Tools Used
- Git
- GitHub
- Postman
- Maven

---

## 3. Application Overview

This application is a **Task Management System** where users can manage tasks efficiently.

The application supports:

| Feature | Description |
|--------|-------------|
| Create | Create new tasks |
| Read | View all tasks |
| Update | Modify existing tasks |
| Delete | Remove tasks |
| Search | Search tasks by keyword |

The frontend communicates with the backend using **REST APIs**.

---

## 4. Database Design

### Table: Task

| Field | Type | Description |
|------|------|-------------|
| id | Long | Primary Key |
| taskTitle | String | Title of task |
| taskDescription | Text | Task description |
| taskDueDate | Date | Due date |
| taskStatus | String | Status of task |
| taskRemarks | String | Additional notes |
| createdOn | Timestamp | Creation time |
| lastUpdatedOn | Timestamp | Last update time |
| createdBy | String | Creator name |
| lastUpdatedBy | String | Last updater |

---

## 5. Data Dictionary

| Column | Description |
|-------|-------------|
| Task Title | Title of the task |
| Task Description | Detailed explanation |
| Task Due Date | Deadline |
| Task Status | Pending / In Progress / Completed |
| Task Remarks | Additional notes |
| Created On | Timestamp when task created |
| Last Updated On | Timestamp when task modified |
| Created By | User who created task |
| Last Updated By | User who modified task |

---

## 6. Indexes Used

Primary Key index on: `id`  
This ensures **fast retrieval and update of tasks**.

---

## 7. Code First vs Database First

This project uses the **Code First Approach**.  
The database schema is generated automatically using **Spring Data JPA entity classes**.

### Benefits
- Faster development
- Easier maintenance
- Automatic schema generation

---

## 8.  ER Diagram

The ER diagram for the database design is included in the repository.

**Location:**  
`docs/ER Diagram.drawio.png`

---

## 9. Application Screenshots

Screenshots demonstrating the working of the application are available in:
`docs/`

---

## 10. Application Architecture

The application follows **MVC architecture**.

```
Frontend (HTML + JS)
        ↓
REST API
        ↓
Spring Boot Controller
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Database
```

 
---

## 11. Frontend Structure

Frontend is implemented using:

- HTML
- JavaScript
- Bootstrap

The frontend acts as a **Single Page Application (SPA)** which communicates with backend APIs using JavaScript fetch calls.

---

## 12. API Endpoints

| Method | Endpoint | Description |
|-------|----------|-------------|
| POST | /api/tasks/createTask | Create task |
| GET | /api/tasks | Get all tasks |
| PUT | /api/tasks/update/{id} | Update task |
| DELETE | /api/tasks/delete/{id} | Delete task |
| GET | /api/tasks/search?keyword= | Search tasks |

---

## 13. Build and Installation

### Environment Requirements
- Java 17+
- Maven
- MySQL
- Git

### Run Backend
Navigate to the backend folder:

```bash
mvn spring-boot:run
```

Server starts on:
http://localhost:8081

Run Frontend  
Open: `frontend/index.html` in your browser.

---

## 14. Demo Workflow

1. Create task  
2. View tasks  
3. Update task  
4. Delete task  
5. Search task  

All operations are performed through **REST API integration**.

---

## 15. Conclusion

This project demonstrates the implementation of a full-stack Task Management System using Java Spring Boot, MySQL, and a web-based frontend.

The application follows MVC architecture and provides full CRUD functionality along with search capability. The project showcases skills in backend development, REST API design, database management, and frontend integration.
