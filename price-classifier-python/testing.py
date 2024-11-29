import pandas as pd
import requests

# Flask API endpoint
FLASK_API_URL = "http://127.0.0.1:5000/predict"

# Load the test data
csv_file = "data\scaled test_data.csv"  # Path to your test dataset
data = pd.read_csv(csv_file)

# Drop the 'id' column (since it is not used in the model)
data = data.drop(columns=["id"], errors="ignore")

# Select a random sample of 10 rows for testing
test_data = data.sample(10, random_state=42)

# Define the expected feature columns
expected_columns = [
    "battery_power", "blue", "clock_speed", "dual_sim", "fc",
    "four_g", "int_memory", "m_dep", "mobile_wt", "n_cores",
    "pc", "px_height", "px_width", "ram", "sc_h", "sc_w",
    "talk_time", "three_g", "touch_screen", "wifi"
]

# Ensure only the expected columns are sent
test_data = test_data[expected_columns]

# Initialize an empty list to store the results
results = []

# Iterate through the test rows and send POST requests
for index, row in test_data.iterrows():
    payload = row.to_dict()  # Convert the row to a dictionary
    print(f"Sending payload for Test {index + 1}: {payload}")

    try:
        # Send HTTP POST request
        response = requests.post(FLASK_API_URL, json=payload)

        # Check response status
        if response.status_code == 200:
            prediction = response.json()
            print(f"Response for Test {index + 1}: {prediction}\n")
            # Save the payload and response into the results
            results.append({**payload, "predicted_price_range": prediction["predicted_price_range"]})
        else:
            print(f"Error for Test {index + 1}: {response.status_code} - {response.text}\n")
            # Save the payload and error message into the results
            results.append({**payload, "predicted_price_range": f"Error: {response.text}"})
    except Exception as e:
        print(f"Error for Test {index + 1}: {e}\n")
        # Save the payload and exception message into the results
        results.append({**payload, "predicted_price_range": f"Exception: {e}"})

# Convert results to a DataFrame
results_df = pd.DataFrame(results)

# Save the results to an Excel file
output_file = "test_results.csv"
results_df.to_csv(output_file, index=False)

print(f"Test results saved to {output_file}")
