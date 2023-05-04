package com.example.service;

import com.example.entity.Driver;
import jakarta.transaction.Transactional;

import java.util.List;

public interface DiverService {
    List<Driver> findAll();
    Driver addDriver(Driver driver);
    boolean deleteById(Long id);

    Driver updateDriver(Driver driver);

    @Transactional
    Driver updateCar(Driver driver);

    Driver findById(Long id);
    Driver findByName(String name);
}
