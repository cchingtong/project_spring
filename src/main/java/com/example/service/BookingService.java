package com.example.service;

import com.example.entity.Booking;

import java.util.List;

public interface BookingService  {

         List<Booking> findAll();
        Booking addBooking(Booking booking);
        boolean deleteById(Long id);

        Booking updateBooking(Booking booking);

        Booking findById(Long id);
}
