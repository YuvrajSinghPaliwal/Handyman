package com.app.HandyMan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.HandyMan.Entity.User;
import com.app.HandyMan.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	     @Autowired
         private  UserService userService;
		
		 @GetMapping
		 public ResponseEntity<List<User>> getAllUsers() {
		     return ResponseEntity.ok(userService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<User> getUserById(@PathVariable Long id) {
		     return userService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		     userService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}

