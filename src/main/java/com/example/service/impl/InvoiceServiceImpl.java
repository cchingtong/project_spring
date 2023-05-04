package com.example.service.impl;

import com.example.Repository.InvoiceRepository;
import com.example.entity.Booking;
import com.example.entity.Invoice;
import com.example.service.InvoiceService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoices::add);
        return invoices;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public boolean deleteById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(invoice)){
            invoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice InvoiceToUpdate = invoiceRepository.findById(invoice.getId()).orElse(null);
        if(!ObjectUtils.isEmpty(invoice)){
            InvoiceToUpdate.setDistance(invoice.getDistance());
            InvoiceToUpdate.setDuration(invoice.getDuration());
            InvoiceToUpdate.setTotal_price(invoice.getTotal_price());
            return invoiceRepository.save(InvoiceToUpdate);
        }
        return null;
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }
}
