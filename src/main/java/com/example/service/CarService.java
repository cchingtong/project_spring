package com.example.service;

import com.example.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car addCar(Car car);
    boolean deleteById(Long id);
    Car updateCar(Car car);
    Car findById(Long id);
    Object findByName(String name);
}
