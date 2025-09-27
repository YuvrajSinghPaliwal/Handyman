package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
}
