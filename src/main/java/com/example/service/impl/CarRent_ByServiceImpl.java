package com.example.service.impl;

import com.example.entity.CarRent_By;
import com.example.entity.Users;
import com.example.Repository.CarRent_ByRepository;
import com.example.service.CarRent_ByService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarRent_ByServiceImpl implements CarRent_ByService{

        private CarRent_ByRepository carRent_ByRepository;

        @Autowired
        public CarRent_ByServiceImpl(CarRent_ByRepository carRent_ByRepository){
            this.carRent_ByRepository = carRent_ByRepository;
        }

        @Override
        public List<CarRent_By> findAll() {
            List<CarRent_By> carRent_byList = new ArrayList<>();
            carRent_ByRepository.findAll().forEach(carRent_byList::add);
            return carRent_byList;
        }

        public CarRent_By add(CarRent_By carRent_by) {
            return carRent_ByRepository.save(carRent_by);
        }

        public boolean deleteById(Long id) {
            CarRent_By carRent_by = carRent_ByRepository.findById(id).orElse(null);
            if(!ObjectUtils.isEmpty(carRent_by)){
                carRent_ByRepository.deleteById(id);
                return true;
            }
            return false;
        }

        @Transactional
        public CarRent_By update(CarRent_By carRent_by) {
            CarRent_By carRent_byToUpdate = carRent_ByRepository.findById(carRent_by.getId()).orElse(null);
            if(!ObjectUtils.isEmpty(carRent_by)){
                carRent_byToUpdate.setCar_type(carRent_by.getCar_type());
                carRent_byToUpdate.setDeposit(carRent_by.getDeposit());
                carRent_byToUpdate.setPickup_date(carRent_by.getPickup_date());
                carRent_byToUpdate.setReturn_date(carRent_by.getReturn_date());
                carRent_byToUpdate.setTotal_price(carRent_by.getTotal_price());
                return carRent_ByRepository.save(carRent_byToUpdate);
            }
            return null;
        }

        public CarRent_By findById(Long id) {
            return carRent_ByRepository.findById(id).orElse(null);
        }


}
