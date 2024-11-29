
# Price Classifier - Spring Boot Component

This component provides the RESTful APIs for managing devices, calling the Flask API for predictions, and storing results in an H2 database.

---

## Features

1. Manages device specifications and predictions using a REST API.
2. Integrates with the Python Flask API for machine learning predictions.
3. Stores device information and prediction results in an H2 in-memory database.

---

## Project Structure

```bash
Spring-Boot-Classifier/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.classifier/   # Main application package
│   │   │   │   ├── controllers/          # REST controllers
│   │   │   │   ├── models/               # Data models
│   │   │   │   ├── services/             # Service layer
│   │   │   │   └── Application.java      # Main Spring Boot application
│   │   └── resources/
│   │       ├── application.properties    # Configuration file
│   │       ├── data.sql                  # Initial SQL scripts
│   │       └── schema.sql                # Database schema
├── pom.xml                  # Maven configuration
├── mvnw                     # Maven wrapper script
└── README.md                # Documentation for Spring Boot component
```

---

## Installation

### Prerequisites

- **Java Development Kit (JDK) 17+** installed.
- **Maven** installed.

### Steps

1. Navigate to the project directory:
   ```bash
   cd Spring-Boot-Classifier
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

---

## Usage

### API Endpoints

#### 1. Add a Device

- **Endpoint**: `/api/devices`
- **Method**: `POST`
- **Request Body Example**:
  ```json
  {
    "battery_power": 1.294038,
    "blue": 1,
    "clock_speed": 1.566254,
    "dual_sim": 0,
    "fc": 1,
    "four_g": 0,
    "int_memory": -0.278599,
    "m_dep": 1.380611,
    "mobile_wt": 1.294042,
    "n_cores": 4,
    "pc": 4,
    "px_height": 1.412573,
    "px_width": 0.265530,
    "ram": 0.250553,
    "sc_h": 1.115486,
    "sc_w": 0.972159,
    "talk_time": 10,
    "three_g": 0,
    "touch_screen": 1,
    "wifi": 1
  }

  ```

#### 2. Predict Device Price

- **Endpoint**: `/api/predict/{deviceId}`
- **Method**: `POST`
- **URL**: `http://127.0.0.1:8080/api/predict/1`

#### 3. Retrieve Device Information

- **Get a Device**: `/api/devices/{id}`
- **Get All Devices**: `/api/devices/`

---

## Accessing the H2 Database

1. Open the H2 console in your browser:
   ```
   http://127.0.0.1:8080/h2-console
   ```

2. Use the following credentials:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: *(leave blank)*

3. Query the database:
   ```sql
   SELECT * FROM DEVICE;
   ```

---
