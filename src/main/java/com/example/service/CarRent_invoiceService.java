package com.example.service;
import com.example.entity.CarRent_invoice;

import java.util.List;

public interface CarRent_invoiceService {

    List<CarRent_invoice> findAll();
    CarRent_invoice add(CarRent_invoice carRent_invoice);
    boolean deleteById(Long id);
    CarRent_invoice update(CarRent_invoice carRent_invoice);
    CarRent_invoice findById(Long id);

}
