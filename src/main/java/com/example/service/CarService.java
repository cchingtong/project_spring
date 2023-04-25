package com.example.service;
import com.example.entity.Car;
import com.example.entity.projection.CarProjection;

import java.util.List;

public interface CarService {

    List<CarProjection> findAll();
    Car addCar(Car car);
    boolean deleteById(Long id);
    Car updateCar(Car car);
    Car findById(Long id);
    CarProjection findByName(String name);
}
