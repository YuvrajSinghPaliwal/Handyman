package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.Review;
import com.app.HandyMan.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

		 @Autowired
		 private ReviewRepo reviewRepo;
		
		 public List<Review> findAll() {
		     return reviewRepo.findAll();
		 }
		
		 public Optional<Review> findById(Long id) {
		     return reviewRepo.findById(id);
		 }
		
		 public Review save(Review review) {
		     return reviewRepo.save(review);
		 }
		
		 public void deleteById(Long id) {
		     reviewRepo.deleteById(id);
		 }
}
