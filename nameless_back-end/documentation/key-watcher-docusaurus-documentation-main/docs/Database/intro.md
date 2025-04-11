---
sidebar_position: 1
sidebar_label: "Introduction to MongoDB"
---

# Introduction to MongoDB

MongoDB is a **document-based database** designed to store data in a flexible, JSON-like format called **BSON (Binary JSON)**. This structure makes it easy to work with complex and varying data models, making MongoDB suitable for event-driven architectures.

## **Why Use MongoDB?**

### **1. Direct Data Insertion**
- Events can be directly inserted as BSON documents.
- Minimal transformation required due to MongoDB's flexible schema.
  
### **2. Data Validation**
- Validation can be handled by:
  - An **intermediate application** (API).
  - **MongoDB Validators**, ensuring correct data formats.

---

## **Core Features**
- **Document-Oriented**: Stores data in JSON-like documents.
- **Scalable & Distributed**: Handles large data volumes efficiently.
- **Schema Flexibility**: Supports dynamic schema updates without downtime.
