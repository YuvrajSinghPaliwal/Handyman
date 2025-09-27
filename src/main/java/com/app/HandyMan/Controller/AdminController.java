package com.app.HandyMan.Controller;

import com.app.HandyMan.Entity.Admin;
import com.app.HandyMan.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

		 @Autowired
		 private AdminService adminService;
		
		 @GetMapping
		 public ResponseEntity<List<Admin>> getAllAdmins() {
		     return ResponseEntity.ok(adminService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
		     return adminService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		     return ResponseEntity.ok(adminService.save(admin));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
		     adminService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}
