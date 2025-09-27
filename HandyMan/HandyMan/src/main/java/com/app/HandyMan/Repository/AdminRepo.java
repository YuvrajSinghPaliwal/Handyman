package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
}

