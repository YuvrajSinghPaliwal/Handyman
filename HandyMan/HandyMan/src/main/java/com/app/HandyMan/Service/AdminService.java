package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.Admin;
import com.app.HandyMan.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

		 @Autowired
		 private AdminRepo adminRepo;
		
		 public List<Admin> findAll() {
		     return adminRepo.findAll();
		 }
		
		 public Optional<Admin> findById(Long id) {
		     return adminRepo.findById(id);
		 }
		
		 public Admin save(Admin admin) {
		     return adminRepo.save(admin);
		 }
		
		 public void deleteById(Long id) {
		     adminRepo.deleteById(id);
		 }
}

