package com.app.HandyMan.Controller;

import com.app.HandyMan.Entity.Payment;
import com.app.HandyMan.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

		 @Autowired
		 private PaymentService paymentService;
		
		 @GetMapping
		 public ResponseEntity<List<Payment>> getAllPayments() {
		     return ResponseEntity.ok(paymentService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		     return paymentService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		     return ResponseEntity.ok(paymentService.save(payment));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		     paymentService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}

