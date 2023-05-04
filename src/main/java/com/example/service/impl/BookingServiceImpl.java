package com.example.service.impl;

import com.example.Repository.BookingRepository;
import com.example.entity.Booking;
import com.example.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public boolean deleteById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(booking)){
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public Booking updateBooking(Booking booking) {
        Booking bookingToUpdate = bookingRepository.findById(booking.getId()).orElse(null);
        if(!ObjectUtils.isEmpty(booking)){
            bookingToUpdate.setBooking_date(booking.getBooking_date());
            bookingToUpdate.setCar(booking.getCar());
            bookingToUpdate.setUser(booking.getUser());
            return bookingRepository.save(bookingToUpdate);
        }
        return null;
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByName(String name) {
        return null;
    }

}
