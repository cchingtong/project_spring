package com.example.service.impl;

import com.example.entity.PickUp;
import com.example.Repository.PickUpRepository;
import com.example.service.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PickUpServiceImpl implements PickUpService {

    private PickUpRepository pickUpRepository;

    @Autowired
    public PickUpServiceImpl(PickUpRepository pickUpRepository){
        this.pickUpRepository = pickUpRepository;
    }

    @Override
    public List<PickUp> findAll() {
        List<PickUp> pickUps = new ArrayList<>();
        pickUpRepository.findAll().forEach(pickUps::add);
        return pickUps;
    }

    @Override
    public PickUp addPickUp(PickUp pickUp) {
        return pickUpRepository.save(pickUp);
    }

    @Override
    public boolean deleteById(Long id) {
        PickUp pickUp = pickUpRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(pickUp)){
            pickUpRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public PickUp updatePickUp(PickUp pickUp) {
        PickUp pickUpToUpdate = pickUpRepository.findById(pickUp.getId()).orElse(null);
        if(!ObjectUtils.isEmpty(pickUp)){
            pickUpToUpdate.setPickup_place(pickUp.getPickup_place());

            return pickUpRepository.save(pickUpToUpdate);
        }
        return null;
    }

    @Override
    public PickUp findById(Long id) {
        return this.pickUpRepository.findById(id).orElse(null);
    }
}

