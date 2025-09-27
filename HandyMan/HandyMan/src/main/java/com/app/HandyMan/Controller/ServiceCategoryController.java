package com.app.HandyMan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.HandyMan.Entity.ServiceCategory;
import com.app.HandyMan.Service.ServiceCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/service-categories")
public class ServiceCategoryController {
	
		 @Autowired
		 private ServiceCategoryService serviceCategoryService;
		
		
		 @GetMapping
		 public ResponseEntity<List<ServiceCategory>> getAllServiceCategories() {
		     return ResponseEntity.ok(serviceCategoryService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<ServiceCategory> getServiceCategoryById(@PathVariable Long id) {
		     return serviceCategoryService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<ServiceCategory> createServiceCategory(@RequestBody ServiceCategory serviceCategory) {
		     return ResponseEntity.ok(serviceCategoryService.save(serviceCategory));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteServiceCategory(@PathVariable Long id) {
		     serviceCategoryService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}

