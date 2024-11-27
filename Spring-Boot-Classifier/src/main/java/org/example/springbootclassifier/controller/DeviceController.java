package org.example.springbootclassifier.controller;
import org.example.springbootclassifier.entity.Device;
import org.example.springbootclassifier.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Retrieve all devices
    @GetMapping("/")
    public ResponseEntity<List<Device>> getAllDevices() {
        try {
            return ResponseEntity.ok(deviceService.getAllDevices());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Retrieve a specific device by ID
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        try {
            Device device = deviceService.getDeviceById(id);
            return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Add a new device
    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        try {
            Device savedDevice = deviceService.addDevice(device);
            return ResponseEntity.ok(savedDevice);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Predict price range for a specific device by ID
    @PostMapping("/predict/{id}")
    public ResponseEntity<Device> predictPrice(@PathVariable Long id) {
        try {
            Device updatedDevice = deviceService.predictPrice(id);
            return ResponseEntity.ok(updatedDevice);
        } catch (Exception e) {
            // Log the error for debugging (optional)
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}
