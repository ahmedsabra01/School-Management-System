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
- View all Students
- View all Teachers
- Search Student/Teacher by name
- Basic Grade structure

# Future Improvements
- Add SchoolService layer
- Implement CRUD operations
- Add search functionality
- Add grade assignment system
- Add database integration using JDBC
- Refactor into layered architecture (Controller / Service / Repository)

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
