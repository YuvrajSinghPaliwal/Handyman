package com.app.HandyMan.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.app.HandyMan.Config.Auditable;

@Entity
@Table(name = "notifications")
public class Notification extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User recipient;

    private String type;
    private String message;
    private Boolean readStatus = false;
    private String channel;
    private String actionUrl;
    private String priority;
    
    // constructors
    
	public Notification(Long id, User recipient, String type, String message, Boolean readStatus, String channel,
			String actionUrl, String priority) {
		super();
		this.id = id;
		this.recipient = recipient;
		this.type = type;
		this.message = message;
		this.readStatus = readStatus;
		this.channel = channel;
		this.actionUrl = actionUrl;
		this.priority = priority;
	}
	public Notification() {
		super();
	}
	
	// getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getRecipient() {
		return recipient;
	}
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(Boolean readStatus) {
		this.readStatus = readStatus;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getActionUrl() {
		return actionUrl;
	}
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
 
}

