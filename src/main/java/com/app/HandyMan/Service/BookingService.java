package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.Booking;
import com.app.HandyMan.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

		 @Autowired
		 private BookingRepo bookingRepo;
		
		 public List<Booking> findAll() {
		     return bookingRepo.findAll();
		 }
		
		 public Optional<Booking> findById(Long id) {
		     return bookingRepo.findById(id);
		 }
		
		 public Booking save(Booking booking) {
		     return bookingRepo.save(booking);
		 }
		
		 public void deleteById(Long id) {
		     bookingRepo.deleteById(id);
		 }
}

