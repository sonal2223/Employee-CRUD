# Employee Attendance Management System

## 📌 Overview
Employee Attendance Management System is a professional backend application developed using Java, Spring Boot, and MySQL. The system is designed to manage employee information and maintain daily attendance records in an efficient and organized manner.

This project demonstrates core backend development concepts such as CRUD operations, RESTful API creation, database relationships, and real-time data management using Spring Boot.

---

## 🚀 Key Features

### 👨‍💼 Employee Management
- Add new employee records
- View all employees
- Search employee by ID
- Update employee details
- Delete employee records

### 📅 Attendance Management
- Mark daily attendance
- Present / Absent status tracking
- Store attendance by date
- View employee attendance history

### 💰 Salary Management
- Store daily salary details
- Ready for monthly salary calculation integration

### 💾 Database Management
- Data stored securely in MySQL
- Structured relational database design

---

## 🛠️ Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL Database
- Maven
- Eclipse IDE
- Postman

---

## 🗄️ Database Schema

### Employees Table
| Column Name   | Description |
|--------------|-------------|
| id           | Employee ID |
| name         | Employee Name |
| email        | Employee Email |
| daily_salary | Employee Daily Salary |

### Attendance Table
| Column Name | Description |
|------------|-------------|
| id         | Attendance ID |
| date       | Attendance Date |
| status     | PRESENT / ABSENT |
| employee_id| Employee Reference ID |

---

## 🌐 REST API Modules

### Employee APIs
- POST /employees
- GET /employees
- GET /employees/{id}
- PUT /employees/{id}
- DELETE /employees/{id}

### Attendance APIs
- POST /attendance
- GET /attendance
- GET /attendance/employee/{id}

---

## ▶️ How to Run Project

1. Clone the repository
2. Open project in Eclipse IDE
3. Create MySQL database
4. Update `application.properties`
5. Run as Spring Boot Application
6. Test APIs using Postman

---

## 🎯 Learning Outcomes
- Spring Boot Architecture
- REST API Development
- CRUD Operations
- Entity Relationships
- Database Integration
- Backend Project Deployment
- GitHub Project Management

---

## 📌 Future Enhancements
- Employee Login Authentication
- Admin Dashboard
- Monthly Salary Auto Calculation
- Search and Pagination
- Export Reports to Excel/PDF
- Frontend Integration using React / Angular

---

## 👨‍💻 Author
Sonal Kumbhar
