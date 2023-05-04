package com.example.Controller;

import com.example.entity.Car;
import com.example.entity.Invoice;
import com.example.service.CarService;
import com.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class InvoiceController {
    private InvoiceService invoiceService;
    private Invoice invoice;

    @Autowired
    public InvoiceController(CarService invoiceService){
        this.invoiceService = (InvoiceService) invoiceService;
    }

    @GetMapping("/all")
    public List<Invoice> findAll(){
        return this.invoiceService.findAll();
    }

    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice){
        return this.invoiceService.addInvoice(invoice);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.invoiceService.deleteById(id);
    }

    @PutMapping
    public Invoice updateInvoice(@RequestBody Car car){
        return this.invoiceService.updateInvoice(invoice);
    }

    @GetMapping("/{id}")
    public Invoice findById(@PathVariable Long id){
        return this.invoiceService.findById(id);
    }

}
