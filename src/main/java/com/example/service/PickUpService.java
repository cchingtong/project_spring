package com.example.service;
import com.example.entity.PickUp;

import java.util.List;

public interface PickUpService {

        List<PickUp> findAll();
        PickUp addPickUp(PickUp pickUp);
        boolean deleteById(Long id);

        PickUp updatePickUp(PickUp pickUp);

        PickUp findById(Long id);
}
