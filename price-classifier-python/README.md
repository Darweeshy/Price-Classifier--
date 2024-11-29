
# Price Classifier - Python Flask Component

This component provides the machine learning model and API for classifying device prices into specific ranges.

---

## Features

1. Implements a **Support Vector Machine (SVM)** model for price classification.
2. Exposes a **Flask API** for making predictions based on device specifications.
3. Includes scripts for data preparation, testing, and model training.

---

## Project Structure

```bash
price-classifier-python/
├── app/                     # Flask application (API for prediction)
│   ├── app.py               # Main Flask API file
│   ├── routes.py            # API routes for prediction
├── scripts/                 # Data preparation and testing scripts
│   ├── preprocess.py        # Preprocessing functions for input data
│   ├── train_model.py       # Script for training the SVM model
├── data/                    # Dataset files (train/test)
├── Notebooks/               # Jupyter notebooks for data exploration and training
├── Svm_Model.pkl            # Trained SVM model
├── testing.py               # Script to test the Flask API
├── requirements.txt         # Python dependencies
└── README.md                # Documentation for Python component
```

---

## Installation

### Prerequisites

- **Python 3.8+** installed on your system.

### Steps

1. Navigate to the project directory:
   ```bash
   cd price-classifier-python
   ```

2. Install the dependencies:
   ```bash
   pip install -r requirements.txt
   ```

3. Start the Flask application:
   ```bash
   python app/app.py
   ```

---

## Usage

### Flask API Endpoint: `/predict`

- **Method**: `POST`
- **URL**: `http://127.0.0.1:5000/predict`
- **Request Body Example**:
  ```json
  {
      "battery_power": 2000,
      "blue": 1,
      "clock_speed": 2.5,
      "dual_sim": 1,
      "fc": 5,
      "four_g": 1,
      "int_memory": 32,
      "m_dep": 0.5,
      "mobile_wt": 150,
      "n_cores": 4,
      "pc": 13,
      "ram": 7000,
      "talk_time": 15,
      "three_g": 1,
      "touch_screen": 1,
      "wifi": 1,
      "px_height": 1920,
      "px_width": 1080,
      "sc_h": 16,
      "sc_w": 8
  }
  ```

- **Response Example**:
  ```json
  {
      "price_range": 2
  }
  ```

---

## Testing

Run the test script to validate the Flask API:
```bash
python testing.py
```
This sends random test data to the `/predict` endpoint and saves the predictions in a CSV file.

---
