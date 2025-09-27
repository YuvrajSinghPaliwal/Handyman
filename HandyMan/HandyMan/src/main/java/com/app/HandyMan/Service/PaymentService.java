package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.Payment;
import com.app.HandyMan.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

		 @Autowired
		 private PaymentRepo paymentRepo;
		
		 public List<Payment> findAll() {
		     return paymentRepo.findAll();
		 }
		
		 public Optional<Payment> findById(Long id) {
		     return paymentRepo.findById(id);
		 }
		
		 public Payment save(Payment payment) {
		     return paymentRepo.save(payment);
		 }
		
		 public void deleteById(Long id) {
		     paymentRepo.deleteById(id);
		 }
}


