package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
}

