package com.example.Controller;

import com.example.entity.Car;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> findAll(){
        return this.carService.findAll();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return this.carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.carService.deleteById(id);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car){
        return this.carService.updateCar(car);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id){
        return this.carService.findById(id);
    }


}