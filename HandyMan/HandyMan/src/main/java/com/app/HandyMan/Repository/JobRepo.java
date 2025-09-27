package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.HandyMan.Entity.Job;

public interface JobRepo extends JpaRepository<Job, Long> {
	
	


}
