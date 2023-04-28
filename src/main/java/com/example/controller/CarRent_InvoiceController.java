package com.example.controller;
import com.example.entity.CarRent_invoice;
import com.example.service.CarRent_invoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/carRent_invoice")
public class CarRent_InvoiceController {

    private CarRent_invoiceService carRent_invoiceService;

    @Autowired
    public CarRent_InvoiceController(CarRent_invoiceService carRent_invoiceService){
        this.carRent_invoiceService = carRent_invoiceService;
    }

    @GetMapping("/all")
    public List<CarRent_invoice> findAll(){
        return this.carRent_invoiceService.findAll();
    }

    @PostMapping
    public CarRent_invoice add(@RequestBody CarRent_invoice carRent_invoice){
        return this.carRent_invoiceService.add(carRent_invoice);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.carRent_invoiceService.deleteById(id);
    }

    @PutMapping
    public CarRent_invoice update(@RequestBody CarRent_invoice carRent_invoice){
        return this.carRent_invoiceService.update(carRent_invoice);
    }

    @GetMapping("/{id}")
    public CarRent_invoice findById(@PathVariable Long id){
        return this.carRent_invoiceService.findById(id);
    }
}
