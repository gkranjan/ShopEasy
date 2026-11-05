## 🛒 ShopEasy – E-Commerce Application

**ShopEasy** is a Java-based E-Commerce application developed using Core Java and Object-Oriented Programming (OOP) principles. It simulates real-world online shopping functionality, allowing users to explore products, manage shopping carts, place orders, and process payments through multiple payment methods.

The project follows a modular, package-based architecture designed to improve code reusability, maintainability, scalability, and separation of responsibilities.

### ✨ Key Features

- **Product Management:** Manage product details, including product ID, name, price, and availability.
- **Shopping Cart:** Add products, manage cart items, and calculate the total order amount.
- **Order Processing:** Handle customer orders and manage the order workflow.
- **Multiple Payment Methods:** Supports UPI and Cash on Delivery (COD) through a common payment interface.
- **Payment Abstraction:** Uses interfaces to provide flexible and extensible payment processing.
- **Modular Architecture:** Organizes application components into separate packages and classes.
- **User Interaction:** Accepts user input to perform shopping and order-related operations.

### 🛠️ Technical Implementation

- **Core Java:** Business logic and application development.
- **Object-Oriented Programming:** Encapsulation, abstraction, inheritance, and polymorphism.
- **Interfaces:** Common payment contract using `IPayment`.
- **Runtime Polymorphism:** Different payment implementations through a common interface.
- **Method Overriding:** Customized payment processing for UPI and Cash on Delivery.
- **Constructor-Based Initialization:** Initialize product and application objects.
- **Package Management:** Maintain a clean and structured codebase.
- **Java 8 Compatibility:** Developed using Java 8-compatible concepts.

### 🏗️ Project Architecture

- `ShopEasyApp` – Application entry point.
- `Product` – Represents product information.
- `ProductService` – Handles product-related operations.
- `CartService` – Manages shopping cart functionality.
- `IPayment` – Defines the common payment contract.
- `UpiPayment` – Implements UPI payment processing.
- `CashOnDelivery` – Implements Cash on Delivery.
- `OrderService` – Handles order processing.

### 🎯 Key Learning Outcomes

- Implemented real-world business logic using Core Java.
- Applied OOP principles to build maintainable applications.
- Understood interface-based programming and runtime polymorphism.
- Practiced modular application development using packages.
- Designed flexible payment processing using abstraction.
- Improved problem-solving and Java programming skills.

**Project Focus:** Core Java | Backend Development | OOP | Interface | Polymorphism | Modular Architecture
