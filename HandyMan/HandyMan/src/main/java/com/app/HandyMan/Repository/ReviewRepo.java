// ReviewRepo.java
package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}

