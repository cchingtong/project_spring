package com.example.service.impl;

import com.example.Repository.DriverRepository;
import com.example.entity.Driver;
import com.example.service.DiverService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl  implements DiverService {
    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }


    @Override
    public List<Driver> findAll() {
        List<Driver> cars = new ArrayList<>();
        driverRepository.findAll().stream().forEach(car -> cars.add((Driver) car));
        return cars;
    }

    @Override
    public Driver addDriver(Driver driver) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(driver)){
            driverRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return null;
    }

    @Transactional
    @Override
    public Driver updateCar(Driver driver) {
        Driver driverToUpdate = driverRepository.findById(driver.getId()).orElse(null);
        if(!ObjectUtils.isEmpty(driver)){
            driverToUpdate.setBookings(driver.getBookings());
            driverToUpdate.setAddress(driver.getAddress());
            driverToUpdate.setIdentity_card(driver.getIdentity_card());
            driverToUpdate.setAge(driver.getAge());
            driverToUpdate.setFname(driver.getFname());
            driverToUpdate.setNumber_phone(driver.getNumber_phone());
            driverToUpdate.setGenderEnum(driver.getGenderEnum());
            return driverRepository.save(driverToUpdate);
        }
        return null;
    }

    @Override
    public Driver findById(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    @Override
    public Driver findByName(String name ) {
        return (Driver) this.driverRepository.findByName(name).orElse(null);
    }
}
