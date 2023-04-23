package com.example.service;

import com.example.entity.CarRent_By;

import java.util.List;

public interface CarRent_ByService {

        List<CarRent_By> findAll();
       CarRent_By add(CarRent_By carRent_by);
        boolean deleteById(Long id);
        CarRent_By update(CarRent_By carRent_by);
        CarRent_By findById(Long id);

}
