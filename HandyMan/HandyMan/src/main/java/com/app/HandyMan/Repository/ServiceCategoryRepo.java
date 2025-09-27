package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.HandyMan.Entity.ServiceCategory;

public interface ServiceCategoryRepo extends JpaRepository<ServiceCategory, Long> {
}

