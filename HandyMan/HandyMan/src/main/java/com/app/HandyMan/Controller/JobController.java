package com.app.HandyMan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.HandyMan.Dtos.HandymanDistanceDto;
import com.app.HandyMan.Dtos.UserLocationDto;
import com.app.HandyMan.Entity.Job;
import com.app.HandyMan.Service.JobService;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	
		 @Autowired
		 private JobService jobService;
		
		
		 @GetMapping
		 public ResponseEntity<List<Job>> getAllJobs() {
		     return ResponseEntity.ok(jobService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		     return jobService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<Job> createJob(@RequestBody Job job) {
		     return ResponseEntity.ok(jobService.save(job));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
		     jobService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
		 
		 @GetMapping("/nearby")
		    public List<HandymanDistanceDto> getNearbyHandymen(
		    		@RequestBody UserLocationDto userLocation,
		            @RequestParam(defaultValue = "10") double radiusKm) { // default 10km
		        return jobService.findNearestHandymen(userLocation, radiusKm);
		    }
		 
}

