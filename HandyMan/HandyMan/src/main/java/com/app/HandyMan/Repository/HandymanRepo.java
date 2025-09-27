package com.app.HandyMan.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.HandyMan.Entity.Handyman;

public interface HandymanRepo extends JpaRepository<Handyman, Long> {

	Optional<Handyman> findByEmail(String email);
}

