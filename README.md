# School Management System (Java)

This is a simple Object-Oriented Programming (OOP) project built in Java to simulate a basic school management system.  
The project is designed for learning and practicing core backend and OOP concepts.

# Project Overview

The system manages:
- Students
- Teachers
- Grades
- School structure

It demonstrates how to organize a Java application using clean OOP principles and layered thinking.

# OOP Concepts Used

- Encapsulation  
  All models use private fields with getters and setters to protect data.

- Abstraction  
  The `Person` class is an abstract class that defines common properties for all people in the system.

- Inheritance
  `Student` and `Teacher` classes extend the `Person` class.

- Polymorphism
  Each subclass overrides `getData()` to provide its own implementation.

# Design Structure

- `Person` → Base abstract class (shared fields: name, age)
- `Student` → Extends Person (adds student-specific data)
- `Teacher` → Extends Person (adds teacher-specific data)
- `Grade` → Groups students and holds grade-related data
- `School` → Stores collections of students, teachers, and grades
- `SchoolService` → Contains business logic and operations
- `HMI` → Handles user interaction (console interface)

# Features (Current Stage)
- Add Student
- Add Teacher
- View All Students
- View All Teachers
- Search Student By Name
- Search Teacher By Name
- Remove Student
- Remove Teacher

# Future Improvements
- Add SchoolService layer
- Implement CRUD operations
- Add search functionality
- Add grade assignment system
- Add database integration using JDBC
- Refactor into layered architecture (Controller / Service / Repository)

# Design Improvements
- Refactored HMI from static design to object-oriented design
- Applied Constructor Injection
- Used private final fields for immutable dependencies
- Improved encapsulation in School and SchoolService
- Reduced code duplication using helper methods

# Tech Stack

- Java
- OOP Principles
- Console-based Application

# Design Idea

The system is designed with separation of concerns:

- Model layer : Represents data structures
- Service layer : Handles business logic
- HMI layer : Handles user interaction

This makes the project easier to extend, maintain, and later migrate to frameworks like Spring Boot.

# Goal of the Project

This project is built for:
- Practicing real-world OOP design
- Preparing for backend development (Spring Boot)
- Learning clean architecture thinking
