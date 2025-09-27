package com.app.HandyMan.Controller;

import com.app.HandyMan.Entity.Booking;
import com.app.HandyMan.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

		 @Autowired
		 private BookingService bookingService;
		
		 @GetMapping
		 public ResponseEntity<List<Booking>> getAllBookings() {
		     return ResponseEntity.ok(bookingService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
		     return bookingService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		     return ResponseEntity.ok(bookingService.save(booking));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
		     bookingService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}

