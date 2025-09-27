package com.app.HandyMan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.HandyMan.Config.GeoUtils;
import com.app.HandyMan.Dtos.HandymanDistanceDto;
import com.app.HandyMan.Dtos.UserLocationDto;
import com.app.HandyMan.Entity.Handyman;
import com.app.HandyMan.Entity.Job;
import com.app.HandyMan.Repository.HandymanRepo;
import com.app.HandyMan.Repository.JobRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {
 
		 @Autowired
		 private JobRepo jobRepository;
		 
		 @Autowired
		 private HandymanRepo handymanRepository;
		 
		 public List<Job> findAll() {
		     return jobRepository.findAll();
		 }
		
		 public Optional<Job> findById(Long id) {
		     return jobRepository.findById(id);
		 }
		
		 public Job save(Job job) {
		     return jobRepository.save(job);
		 }
		
		 public void deleteById(Long id) {
		     jobRepository.deleteById(id);
		 }
		 
		 public List<HandymanDistanceDto> findNearestHandymen(UserLocationDto userLocation, double maxDistanceKm) {
		        List<Handyman> allHandymen = handymanRepository.findAll();

		        return allHandymen.stream()
		                .map(h -> {
		                    double distance = GeoUtils.calculateDistance(userLocation.getLatitude(), userLocation.getLongitude(), h.getLatitude(), h.getLongitude());
		                    return new HandymanDistanceDto(h, distance);
		                })
		                .filter(dto -> dto.getDistance() <= maxDistanceKm) // filter only within X km
		                .sorted(Comparator.comparingDouble(HandymanDistanceDto::getDistance)) // nearest first
		                .collect(Collectors.toList());
		    }
		 
}

