package com.example.service.impl;

import com.example.Repository.CarRent_invoiceRepository;
import com.example.entity.CarRent_invoice;
import com.example.service.CarRent_invoiceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarRent_InvoiceServiceImpl implements CarRent_invoiceService{

        private CarRent_invoiceRepository carRent_invoiceRepository;

        @Autowired
        public CarRent_InvoiceServiceImpl(CarRent_invoiceRepository carRent_invoiceRepository){
            this.carRent_invoiceRepository = carRent_invoiceRepository;
        }

        @Override
        public List<CarRent_invoice> findAll() {
            List<CarRent_invoice> carRent_invoices = new ArrayList<>();
            carRent_invoiceRepository.findAll().forEach(carRent_invoices::add);
            return carRent_invoices;
        }

        @Override
        public CarRent_invoice add(CarRent_invoice carRent_invoice) {
            return carRent_invoiceRepository.save(carRent_invoice);
        }

        @Override
        public boolean deleteById(Long id) {
            CarRent_invoice carRent_invoice = carRent_invoiceRepository.findById(id).orElse(null);
            if(!ObjectUtils.isEmpty(carRent_invoice)){
                carRent_invoiceRepository.deleteById(id);
                return true;
            }
            return false;
        }

        @Transactional
        @Override
        public CarRent_invoice update(CarRent_invoice carRent_invoice) {
            CarRent_invoice carRent_invoiceToUpdate = carRent_invoiceRepository.findById(carRent_invoice.getId()).orElse(null);
            if(!ObjectUtils.isEmpty(carRent_invoice)){
                carRent_invoiceToUpdate.setDeposit(carRent_invoice.getDeposit());
                carRent_invoiceToUpdate.setTotal_price(carRent_invoice.getTotal_price());
                return carRent_invoiceRepository.save(carRent_invoiceToUpdate);
            }
            return null;
        }

    @Override
    public CarRent_invoice findById(Long id) {
        return carRent_invoiceRepository.findById(id).orElse(null);

    }


}
