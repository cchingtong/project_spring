package com.example.service;

import com.example.entity.Booking;
import com.example.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();
    Invoice addInvoice(Invoice invoice);
    boolean deleteById(Long id);

    Invoice updateInvoice(Invoice invoice);

    Invoice findById(Long id);
}
