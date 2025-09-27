package com.app.HandyMan.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.HandyMan.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}

