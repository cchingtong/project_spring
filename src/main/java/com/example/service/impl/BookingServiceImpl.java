//package com.example.service.impl;
//
//
//import com.example.entity.Booking;
//
//import com.example.repository.BookingRepository;
//
//import com.example.service.BookingService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//public class BookingServiceImpl implements BookingService {
//
//    final BookingRepository bookingRepository;
//    @Autowired
//    public BookingServiceImpl(BookingRepository bookingRepository){
//        this.bookingRepository = bookingRepository;
//    }
//
//
//    @Override
//    public Booking add(Booking booking) {
////        booking.setCreatedBy("Admin");
//        return this.bookingRepository.save(booking);
//    }
//
//    @Override
//    public Booking update(Booking booking) {
//        Booking boo = this.bookingRepository.findById(Booking.getId()).orElse(null);
//        if (boo == null) {
//            return null;
//        }
//        return this.bookingRepository.save(boo);
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        Booking boo = this.bookingRepository.findById(id).orElse(null);
//        if (boo == null) {
//            return false;
//        }
//        this.bookingRepository.deleteById(id);
//        return true;
//    }
//}