package com.app.HandyMan.Controller;

import com.app.HandyMan.Entity.SupportTicket;
import com.app.HandyMan.Service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

		 @Autowired
		 private SupportTicketService supportTicketService;
		
		 @GetMapping
		 public ResponseEntity<List<SupportTicket>> getAllSupportTickets() {
		     return ResponseEntity.ok(supportTicketService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<SupportTicket> getSupportTicketById(@PathVariable Long id) {
		     return supportTicketService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<SupportTicket> createSupportTicket(@RequestBody SupportTicket supportTicket) {
		     return ResponseEntity.ok(supportTicketService.save(supportTicket));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteSupportTicket(@PathVariable Long id) {
		     supportTicketService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}


