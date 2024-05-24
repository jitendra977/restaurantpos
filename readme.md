# Restaurant POS System

A Restaurant Point of Sale (POS) system built with Spring Boot to manage orders, track sales, and handle various restaurant operations.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

The Restaurant POS System is designed to streamline the process of managing a restaurant's sales, orders, and inventory. It provides a user-friendly interface for employees to place orders and for managers to view sales reports and manage inventory.

## Entities

1. **Customer:**
   - Represents a customer of the restaurant.
   - Attributes:
     - id: Unique identifier for the customer.
     - name: Name of the customer.
     - phone_number: Phone number of the customer.
     - email: Email address of the customer.
     - address: Address of the customer.

2. **Table:**
   - Represents a table in the restaurant.
   - Attributes:
     - id: Unique identifier for the table.
     - table_number: Number assigned to the table.
     - capacity: Maximum capacity of the table (number of seats).

3. **MenuItem:**
   - Represents a food or beverage item on the menu.
   - Attributes:
     - id: Unique identifier for the menu item.
     - name: Name of the menu item.
     - description: Description of the menu item.
     - price: Price of the menu item.
     - category: Category of the menu item (e.g., appetizer, main course, dessert).

4. **Order:**
   - Represents an order placed by a customer.
   - Attributes:
     - id: Unique identifier for the order.
     - customer: Customer who placed the order.
     - table: Table at which the order was placed.
     - order_time: Date and time when the order was placed.
     - total_amount: Total amount payable for the order.

5. **OrderItem:**
   - Represents an item included in an order.
   - Attributes:
     - id: Unique identifier for the order item.
     - order: Order to which the item belongs.
     - menuItem: Menu item included in the order.
     - quantity: Quantity of the menu item ordered.
     - item_price: Price of the menu item.
     - total_price: Total price for the quantity of menu item ordered.

6. **Payment:**
   - Represents a payment made for an order.
   - Attributes:
     - id: Unique identifier for the payment.
     - order: Order for which the payment is made.
     - payment_method: Method used for payment (e.g., cash, credit card).
     - payment_time: Date and time when the payment was made.
     - amount_paid: Amount paid for the order.

## Database Configuration

The system uses JPA (Java Persistence API) for object-relational mapping. It is configured to use an SQL database, such as MySQL or PostgreSQL. Each entity is mapped to a corresponding table in the database, and relationships between entities are established using annotations such as `@ManyToOne`, `@OneToOne`, and `@JoinColumn`.

## Service Layer

The service layer contains business logic for performing operations on entities. It includes methods for creating, reading, updating, and deleting entities. For example, there are methods for placing orders, adding items to orders, processing payments, etc.

## Controller Layer

The controller layer exposes RESTful endpoints for interacting with the system. It handles HTTP requests, calls the appropriate methods in the service layer, and returns HTTP responses. For example, there are endpoints for creating orders, updating customer information, viewing menu items, etc.
## Features

- **Order Management**: Easily create, update, and delete orders.
- **Inventory Management**: Track stock levels and manage inventory items.
- **Sales Reports**: Generate detailed reports on sales and performance.
- **User Authentication**: Secure login for employees and administrators.
- **Real-time Updates**: Instant updates on order status and inventory changes.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySql Database**
- **Spring Security**
- **React** (for the web interface)
- **HTML/CSS/JavaScript**

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

- Java 17 or higher
- Maven

### Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/jitendra977/restaurantpos.git
