# PharmaChain 🚑💊

PharmaChain is a backend-first Pharmacy Inventory & Order Management System
designed for real-world pharmaceutical operations.

## 🚀 Features
- Medicine & Batch-wise Inventory
- Expiry Date Tracking (30/60/90 days ready)
- Order Management with Transaction Safety
- Distributor (Supplier) Management
- Reports: Low Stock, Expiry, Full Stock
- Global Exception Handling
- DTO-based Clean APIs
- Basic Authentication & Role-based Access
- Validation & Compliance-ready Design

## 🏗 Architecture
- Spring Boot (JDK 8 compatible)
- Layered Architecture
    - Controller
    - Service
    - Repository
    - Entity
    - DTO
    - Exception
    - Security
- MySQL Database
- Maven Build Tool

## 🔐 Security
- Basic Authentication
- Roles:
    - ADMIN → Full Access
    - STAFF → Reports Access

## ⚙️ Transaction Management
- Atomic order placement
- Auto stock deduction
- Rollback on failure

## 📦 Modules
1. Inventory & Batch
2. Orders
3. Distributors
4. Reports
5. Security
6. Exception Handling

## 🧪 API Testing
(Postman testing will be added later)

## 👨‍💻 Developer
Built with Sahil Dhamecha