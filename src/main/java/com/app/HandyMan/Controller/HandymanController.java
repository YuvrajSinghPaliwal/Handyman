package com.app.HandyMan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.HandyMan.Entity.Handyman;
import com.app.HandyMan.Service.HandymanService;

import java.util.List;

@RestController
@RequestMapping("/api/handymen")
public class HandymanController {
	
	     @Autowired
		 private HandymanService handymanService;
		
		 public HandymanController(HandymanService handymanService) {
		     this.handymanService = handymanService;
		 }
		
		 @GetMapping
		 public ResponseEntity<List<Handyman>> getAllHandymen() {
		     return ResponseEntity.ok(handymanService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Handyman> getHandymanById(@PathVariable Long id) {
		     return handymanService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteHandyman(@PathVariable Long id) {
		     handymanService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}

