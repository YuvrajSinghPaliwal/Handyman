package com.app.HandyMan.Entity;


import com.app.HandyMan.Config.Auditable;
import com.app.HandyMan.Enums.TicketStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "support_tickets")
public class SupportTicket extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String subject;
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.OPEN;

    private String responseNotes;
    private String ticketNumber;
    private String attachments;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "assigned_admin_id")
    private Admin assignedAdmin;

    // constructors
    
	public SupportTicket(Long id, User user, String subject, String description, TicketStatus status,
			String responseNotes, String ticketNumber, String attachments, String priority, Admin assignedAdmin) {
		super();
		this.id = id;
		this.user = user;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.responseNotes = responseNotes;
		this.ticketNumber = ticketNumber;
		this.attachments = attachments;
		this.priority = priority;
		this.assignedAdmin = assignedAdmin;
	}

	public SupportTicket() {
		super();
	}

	// getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public String getResponseNotes() {
		return responseNotes;
	}

	public void setResponseNotes(String responseNotes) {
		this.responseNotes = responseNotes;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Admin getAssignedAdmin() {
		return assignedAdmin;
	}

	public void setAssignedAdmin(Admin assignedAdmin) {
		this.assignedAdmin = assignedAdmin;
	}
    
}

