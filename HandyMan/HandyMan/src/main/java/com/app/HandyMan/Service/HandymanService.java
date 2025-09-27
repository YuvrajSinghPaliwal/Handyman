package com.app.HandyMan.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.HandyMan.Dtos.HandymanRegistrationDto;
import com.app.HandyMan.Entity.Handyman;
import com.app.HandyMan.Repository.HandymanRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HandymanService {
	
	 @Autowired
     private HandymanRepo handymanRepository;
	 
	 @Autowired
     private DtoToEntityMapperService mapper;

	 private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

     public List<Handyman> findAll() {
          return handymanRepository.findAll();
     }

     public Optional<Handyman> findById(Long id) {
          return handymanRepository.findById(id);
     }

     public Handyman save(HandymanRegistrationDto handymanDto) {
    	    // Check if a handyman with the same email already exists
    	    Optional<Handyman> optional = handymanRepository.findByEmail(handymanDto.getEmail());
    	    if (optional.isPresent()) {
    	        // Return null or you can throw a custom exception if preferred
    	        return null;
    	    }

    	    // mapint dto to handyman
    	    Handyman handyman = mapper.mapHandymanDtoToEntity(handymanDto);

    	    // Save the handyman to the repository
    	    return handymanRepository.save(handyman);
    	}


     public void deleteById(Long id) {
         handymanRepository.deleteById(id);
     }
     
     public Handyman authenticate(String email, String rawPassword) {
	        return handymanRepository.findByEmail(email)
	               .filter(handyman -> encoder.matches(rawPassword, handyman.getPassword()))
	               .orElse(null);
	 }
     
     public Handyman update(Handyman handyman) {
	        if (!handymanRepository.existsById(handyman.getId())) {
	            throw new RuntimeException("User not found with id " + handyman.getId());
	        }
	        else{
	        	handyman.setPassword(encoder.encode(handyman.getPassword()));
	        }
	        return handymanRepository.save(handyman);
	    }
}

