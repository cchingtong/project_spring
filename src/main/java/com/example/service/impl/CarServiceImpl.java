package com.example.service.impl;

import com.example.entity.Car;
import com.example.service.CarService;
import com.example.Repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CarServiceImpl implements CarService{

        private CarRepository carRepository;

        @Autowired
        public CarServiceImpl(CarRepository carRepository){
            this.carRepository = carRepository;
        }

        @Override
        public List<Car> findAll() {
            List<Car> cars = new ArrayList<>();
            carRepository.findAll().forEach(cars::add);
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
            carToUpdate.setCarRent_by(car.getCarRent_by());

            return carRepository.save(carToUpdate);
        }
        return null;
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }


}
