package com.example.service;

import com.example.entity.Booking;
public interface BookingService {
    Booking add(Booking booking);
    Booking update(Booking booking);
    boolean deleteById(Long id);
}

