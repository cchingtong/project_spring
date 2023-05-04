package com.example.service.impl;

import com.example.Repository.CarRepository;
import com.example.entity.Car;
import com.example.service.CarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().stream().forEach(car -> cars.add((Car) car));
        return cars;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public boolean deleteById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(car)){
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Transactional
    @Override
    public Car updateCar(Car car) {
        Car carToUpdate = carRepository.findById(car.getId()).orElse(null);
        if(!ObjectUtils.isEmpty(car)){
            carToUpdate.setCompany(car.getCompany());
            carToUpdate.setSeat(car.getSeat());
            carToUpdate.setType(car.getType());
            carToUpdate.setPlate_number(car.getPlate_number());
            carToUpdate.setModel_year(car.getModel_year());
            return carRepository.save(carToUpdate);
        }
        return null;
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car findByName(String name) {
        return (Car) this.carRepository.findByName(name).orElse(null);
    }
}
