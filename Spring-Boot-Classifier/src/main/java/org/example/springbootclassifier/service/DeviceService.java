package org.example.springbootclassifier.service;
import org.example.springbootclassifier.entity.Device;
import org.example.springbootclassifier.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    private static final String PYTHON_API_URL = "http://127.0.0.1:5000/predict";

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device predictPrice(Long id) throws Exception {
        Device device = getDeviceById(id);
        if (device == null) {
            throw new Exception("Device not found for ID: " + id);
        }

        // Prepare payload for the Flask API
        Map<String, Object> payload = new HashMap<>();
        payload.put("battery_power", device.getBattery_power());
        payload.put("blue", device.getBlue());
        payload.put("clock_speed", device.getClock_speed());
        payload.put("dual_sim", device.getDual_sim());
        payload.put("fc", device.getFc());
        payload.put("four_g", device.getFour_g());
        payload.put("int_memory", device.getInt_memory());
        payload.put("m_dep", device.getM_dep());
        payload.put("mobile_wt", device.getMobile_wt());
        payload.put("n_cores", device.getN_cores());
        payload.put("pc", device.getPc());
        payload.put("ram", device.getRam());
        payload.put("talk_time", device.getTalk_time());
        payload.put("three_g", device.getThree_g());
        payload.put("touch_screen", device.getTouch_screen());
        payload.put("wifi", device.getWifi());
        payload.put("px_h" , device.getPx_height());
        payload.put("px_w" , device.getPx_width());
        payload.put("sc_h", device.getSc_h());
        payload.put("sc_w", device.getSc_w());
        // Call Flask API
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> response = restTemplate.postForObject(PYTHON_API_URL, payload, Map.class);

        if (response != null && response.containsKey("predicted_price_range")) {
            int predictedPrice = response.get("predicted_price_range");
            device.setPredicted_price_range(predictedPrice);

            // Save updated device to the database
            return deviceRepository.save(device);
        } else {
            throw new Exception("Prediction failed from Flask API.");
        }
    }
}
