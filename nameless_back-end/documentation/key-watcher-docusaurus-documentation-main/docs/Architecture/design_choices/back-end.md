---
sidebar_position: 1
sidebar_label: "Back-end"
---

# Back-end Architecture Overview

This section outlines the key technologies, tools, and architectural principles used in the back-end development of the project, emphasizing scalability, maintainability, and streamlined development.

---

## **🔧 Technologies & Tools**

### **1. Spring Boot**
- Simplifies Java backend development by reducing boilerplate code.
- Offers built-in support for RESTful APIs and microservices.
- Ideal for building scalable, production-ready applications.

---

### **2. Rest Template**
- Facilitates HTTP communication and API integration.
- Automatically deserializes responses into Java objects.
- Ensures seamless integration with external services.

---

### **3. Lombok**
- Reduces boilerplate code by generating common methods like getters and setters.
- Improves code clarity and maintainability.
- Especially useful in projects with many model classes.

---

### **4. JUnit**
- Used for unit testing to ensure code reliability.
- Supports test-driven development (TDD).
- Helps maintain high code quality and reduce bugs.

---

### **5. Docker**
- Used for containerizing applications.
- Ensures consistent environments across development, testing, and production.
- Simplifies deployment and application scaling.

---

### **6. Continuous Integration Runner**
- Automates testing and deployment processes.
- Facilitates seamless integration of changes from multiple developers.
- Ensures that builds are stable, automates testing, and promotes a robust workflow.

---

### **7. Gradle**
- Build automation tool known for its flexibility and powerful dependency management.
- Simplifies project builds and supports multi-project setups.
- Enhances build performance with incremental builds.

---

### **8. ModelMapper**
- Simplifies object mapping between different data models.
- Facilitates conversion of DTOs to entity objects and vice versa.
- Supports complex mappings and custom transformations, reducing manual mapping code.

---

### **9. Jakarta Validation**
- Framework for validating JavaBeans using annotations.
- Enforces constraints on data models.
- Ensures data integrity through predefined validation rules.

---

---

## **🏛️ Architectural Choices**

### **1. Interfaces within the Business Layer**
- Interfaces are implemented in the logic layer to facilitate **Dependency Inversion** for the Data Access Layer (DAL).
- This improves separation of concerns and enhances testability and maintainability.

---

### **2. Mapping in Services Instead of Controllers**
- **Services** handle data processing and implement business logic.
- **Controllers** focus solely on exposing data to clients.
- This separation keeps controllers streamlined and improves readability and code organization.

---

### **3. SOLID Principles**
A set of five key design principles aimed at creating maintainable and scalable software:

1. **S**ingle Responsibility: Each class should have a single responsibility.
2. **O**pen/Closed Principle: Classes should be open for extension but closed for modification.
3. **L**iskov Substitution: Derived classes should be replaceable by their base classes.
4. **I**nterface Segregation: Clients should not be forced to depend on interfaces they don't use.
5. **D**ependency Inversion: Depend on abstractions, not concrete implementations.

---

### **4. 3-Layer Architecture**
A standard design pattern that divides the application into three distinct layers:

1. **Presentation Layer (UI)**:
   - Manages user interactions.
   - Handles user interface components.

2. **Business Logic Layer (BLL)**:
   - Processes data and implements core business rules.
   - Contains services and business logic implementations.

3. **Data Access Layer (DAL)**:
   - Manages interactions with external data sources (e.g., databases).
   - Contains repositories and database queries.

---

By following these principles and using the technologies mentioned, the back-end architecture ensures a clean, scalable, and maintainable system while enabling easier future enhancements.