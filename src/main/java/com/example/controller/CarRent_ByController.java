package com.example.controller;

import com.example.entity.CarRent_By;
import com.example.service.impl.CarRent_ByServiceImpl;
import com.example.service.CarRent_ByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class CarRent_ByController {

        private CarRent_ByServiceImpl carRent_byService;

        @Autowired
        public CarRent_ByController(CarRent_ByServiceImpl carRent_byService){
            this.carRent_byService = carRent_byService;
        }

        @GetMapping("/all")
        public Iterable<CarRent_By> findAll(){
            return this.carRent_byService.findAll();
        }

        @PostMapping
        public CarRent_By add(@RequestBody CarRent_By carRent_by){
            return this.carRent_byService.add(carRent_by);
        }

        @DeleteMapping("/{id}")
        public boolean delete(@PathVariable Long id){
            return this.carRent_byService.deleteById(id);
        }

        @PutMapping
        public CarRent_By update(@RequestBody CarRent_By carRent_by){
            return this.carRent_byService.update(carRent_by);
        }

        @GetMapping("/{id}")
        public CarRent_By findById(@PathVariable Long id){
            return this.carRent_byService.findById(id);
        }
}
