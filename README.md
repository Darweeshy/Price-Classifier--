
# Devices Price Classification System

This repository provides a complete system for predicting and classifying device prices using machine learning and web technologies. It consists of two main components:

1. **Python Flask Project**: Implements a machine learning model (Support Vector Machine) to classify devices into price ranges.
2. **Spring Boot Project**: Provides RESTful APIs for managing devices, integrating with the Flask API for predictions, and storing the results in an H2 database.

---

## Table of Contents

1. [Getting Started](#getting-started)
2. [Running the Flask Project](#running-the-flask-project)
3. [Running the Spring Boot Project](#running-the-spring-boot-project)
4. [Adding Devices](#adding-devices)
5. [Making Predictions](#making-predictions)
6. [Retrieving Devices](#retrieving-devices)
7. [Testing with the Python Script](#testing-with-the-python-script)
8. [Accessing the H2 Database](#accessing-the-h2-database)
9. [Project Structure](#project-structure)

---

## Getting Started

### Prerequisites

Make sure you have the following installed:

- **Python 3.8+**
- **Java Development Kit (JDK) 17+**
- **Maven**
- **Postman** or `curl` for API testing (optional)

---

## Running the Flask Project

### 1. Navigate to the Python Project Directory

Go to the Flask project directory:
```bash
cd price-classifier-python
```

---

### 2. Install Flask Project Dependencies

To install the required dependencies for the Flask project, run:
```bash
pip install -r requirements.txt
```

---

### 3. Start the Flask Application

1. Start the Flask app:
   ```bash
   python app/app.py
   ```

2. Verify that the Flask API is running by visiting:
   ```
   http://127.0.0.1:5000
   ```

---

### 4. Test the Flask API Using Postman or curl

#### Flask API Endpoint: `/predict`

- **Method**: `POST`
- **URL**: `http://127.0.0.1:5000/predict`
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

#### Example `curl` Request:
```bash
curl -X POST http://127.0.0.1:5000/predict -H "Content-Type: application/json" -d ' {
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
   }'
```

---

## Running the Spring Boot Project

### 1. Navigate to the Spring Boot Project Directory

Go to the Spring Boot project directory:
```bash
cd Spring-Boot-Classifier
```

---

### 2. Build the Project Using Maven

Run the following command to build the project:
```bash
mvn clean install
```

---

### 3. Start the Spring Boot Application

Run the application:
```bash
mvn spring-boot:run
```

Verify the Spring Boot API is running by visiting:
```
http://127.0.0.1:8080/api
```

---

### Adding Devices

You can add device details to the system using the Spring Boot API.

#### Spring Boot API Endpoint: `/api/devices`
- **Method**: `POST`
- **URL**: `http://127.0.0.1:8080/api/devices`
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

#### Example `curl` Request:
```bash
curl -X POST http://127.0.0.1:8080/api/devices -H "Content-Type: application/json" -d ' {
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
   }'
```

---

### Making Predictions

Use the Spring Boot API to predict the price range of a stored device.

#### Spring Boot API Endpoint: `/api/predict/{deviceId}`
- **Method**: `POST`
- **URL**: `http://127.0.0.1:8080/api/predict/{deviceId}`

#### Example `curl` Request:
```bash
curl -X POST http://127.0.0.1:8080/api/predict/1
```

This will send the device with ID `1` to the Flask API for prediction. The prediction result will be saved in the database.

---

### Retrieving Devices

#### Get a Specific Device by ID
- **Endpoint**: `/api/devices/{id}`
- **Method**: `GET`
- **Example `curl` Command**:
  ```bash
  curl -X GET http://127.0.0.1:8080/api/devices/1
  ```

#### Get All Devices
- **Endpoint**: `/api/devices/`
- **Method**: `GET`
- **Example `curl` Command**:
  ```bash
  curl -X GET http://127.0.0.1:8080/api/devices/
  ```

---

### Testing with the Python Script

A test script is provided to send random device specifications to the Flask API for predictions.

1. Navigate to the Python project directory:
   ```bash
   cd price-classifier-python
   ```

2. Run the test script:
   ```bash
   python testing.py
   ```

The script will generate random test data, send it to the Flask API, and save the predictions in a CSV file (`predictions.csv`).

---

### Accessing the H2 Database

The Spring Boot application uses an H2 in-memory database. To access the database:

1. Open your browser and go to:
   ```
   http://127.0.0.1:8080/h2-console
   ```

2. Use the following credentials:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: *(leave blank)*

3. Run SQL queries to view or manage the data. For example:
   ```sql
   SELECT * FROM DEVICE;
   ```

---

### Project Structure

```bash
price-classifier/
├── price-classifier-python/
│   ├── app/                     # Flask application (API for prediction)
│   ├── Notebooks/               # Jupyter notebooks for data exploration and training
│   ├── data/                    # Dataset files (train/test)
│   ├── Svm_Model.pkl            # Trained SVM model
│   ├── testing.py               # Script to test the Flask API
│   ├── requirements.txt         # Python dependencies
│   └── README.md                # Documentation for Python component
├── Spring-Boot-Classifier/
│   ├── src/                     # Spring Boot source code
│   ├── pom.xml                  # Maven configuration
│   ├── mvnw                     # Maven wrapper script
│   └── README.md                # Documentation for Spring Boot component
└── README.md                    # Main project documentation
```

---

