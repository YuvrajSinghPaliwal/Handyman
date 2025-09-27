package com.app.HandyMan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.HandyMan.Entity.ServiceCategory;
import com.app.HandyMan.Repository.ServiceCategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoryService {
	      
         @Autowired
		 private ServiceCategoryRepo serviceCategoryRepository;
		
		 public List<ServiceCategory> findAll() {
		     return serviceCategoryRepository.findAll();
		 }
		
		 public Optional<ServiceCategory> findById(Long id) {
		     return serviceCategoryRepository.findById(id);
		 }
		
		 public ServiceCategory save(ServiceCategory serviceCategory) {
		     return serviceCategoryRepository.save(serviceCategory);
		 }
		
		 public void deleteById(Long id) {
		     serviceCategoryRepository.deleteById(id);
		 }
}

