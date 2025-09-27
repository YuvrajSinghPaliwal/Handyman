package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}

