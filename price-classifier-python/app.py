from flask import Flask, request, jsonify
import joblib
import pandas as pd

app = Flask(__name__)

# Load the trained model
model = joblib.load('Svm_Model.pkl')

# Load the training dataset
train_data = pd.read_csv('data\scaled train_data.csv')
csv_file = "data/test - test.csv"  

# Precompute statistics for handling missing values
expected_columns = [
    "battery_power", "blue", "clock_speed", "dual_sim", "fc",
    "four_g", "int_memory", "m_dep", "mobile_wt", "n_cores",
    "pc", "px_height", "px_width", "ram", "sc_h", "sc_w",
    "talk_time", "three_g", "touch_screen", "wifi"
]

# Compute column-wise statistics
column_medians = train_data[expected_columns].median()  # Median for numerical columns
column_means = train_data[['fc']].mean()  # Mean for `fc`
column_modes = train_data[['four_g', 'n_cores']].mode().iloc[0]  # Mode for categorical columns


@app.route("/predict", methods=["POST"])
def predict():
    try:
        # Log incoming payload
        data = request.get_json()
        print("Received payload:", data)

        # Convert payload to DataFrame
        features = pd.DataFrame([data])

        # Ensure all expected columns are present and fill missing values
        for col in expected_columns:
            if col not in features.columns:
                if col in column_means:
                    features[col] = column_means[col]  # Use mean for `fc`
                elif col in column_modes:
                    features[col] = column_modes[col]  # Use mode for categorical columns
                else:
                    features[col] = column_medians[col]  # Use median for numerical columns

        # Predict price range
        prediction = model.predict(features[expected_columns])
        return jsonify({"predicted_price_range": int(prediction[0])})

    except Exception as e:
        print("Error processing prediction:", e)
        return jsonify({"error": str(e)}), 400


if __name__ == '__main__':
    app.run(debug=True, port=5000)

