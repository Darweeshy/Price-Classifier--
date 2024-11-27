from flask import Flask, request, jsonify
import joblib
import pandas as pd

app = Flask(__name__)

# Load the trained model
model = joblib.load('Svm_Model.pkl')


@app.route("/predict", methods=["POST"])
def predict():
    try:
        # Log incoming payload
        data = request.get_json()
        print("Received payload:", data)

        # Define expected feature columns
        expected_columns = [
         "battery_power", "blue", "clock_speed", "dual_sim", "fc", 
        "four_g", "int_memory", "m_dep", "mobile_wt", "n_cores", 
        "pc", "px_height", "px_width", "ram", "sc_h", "sc_w", 
        "talk_time", "three_g", "touch_screen", "wifi"
        ]
        # Assuming the model was trained on a DataFrame

        # Convert payload to DataFrame
        features = pd.DataFrame([data])

        # Ensure all expected columns are present
        for col in expected_columns:
            if col not in features.columns:
                features[col] = 0  # Assign default value for missing columns

        # Predict price range
        prediction = model.predict(features[expected_columns])
        return jsonify({"predicted_price_range": int(prediction[0])})
    except Exception as e:
        print("Error processing prediction:", e)
        return jsonify({"error": str(e)}), 400


if __name__ == '__main__':
    app.run(debug=True, port=5000)

