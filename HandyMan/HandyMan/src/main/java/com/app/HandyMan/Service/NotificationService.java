package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.Notification;
import com.app.HandyMan.Repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

		 @Autowired
		 private NotificationRepo notificationRepo;
		
		 public List<Notification> findAll() {
		     return notificationRepo.findAll();
		 }
		
		 public Optional<Notification> findById(Long id) {
		     return notificationRepo.findById(id);
		 }
		
		 public Notification save(Notification notification) {
		     return notificationRepo.save(notification);
		 }
		
		 public void deleteById(Long id) {
		     notificationRepo.deleteById(id);
		 }
}

