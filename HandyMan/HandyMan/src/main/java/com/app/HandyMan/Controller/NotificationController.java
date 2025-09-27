package com.app.HandyMan.Controller;

import com.app.HandyMan.Entity.Notification;
import com.app.HandyMan.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

		 @Autowired
		 private NotificationService notificationService;
		
		 @GetMapping
		 public ResponseEntity<List<Notification>> getAllNotifications() {
		     return ResponseEntity.ok(notificationService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
		     return notificationService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
		     return ResponseEntity.ok(notificationService.save(notification));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
		     notificationService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}
