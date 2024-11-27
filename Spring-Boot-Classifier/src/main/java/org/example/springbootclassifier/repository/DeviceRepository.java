package org.example.springbootclassifier.repository;

import org.example.springbootclassifier.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
