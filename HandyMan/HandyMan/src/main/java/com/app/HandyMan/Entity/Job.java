package com.app.HandyMan.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.app.HandyMan.Config.Auditable;
import com.app.HandyMan.Enums.JobStatus;

@Entity
@Table(name = "jobs")
public class Job extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "handyman_id")
    private Handyman handyman;

    @ManyToOne
    @JoinColumn(name = "service_category_id")
    private ServiceCategory serviceCategory;

    private String description;
    private String location;
    private LocalDateTime requestedDateTime;

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.PENDING;

    private Double price;
    private Boolean paymentStatus = false;

    private String jobCode;
    private LocalDateTime acceptedDateTime;
    private LocalDateTime completedDateTime;
    private LocalDateTime cancelledDateTime;
    private String cancellationReason;
    private String attachments;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    // constructors
    
	public Job(Long id, User customer, Handyman handyman, ServiceCategory serviceCategory, String description,
			String location, LocalDateTime requestedDateTime, JobStatus status, Double price, Boolean paymentStatus,
			String jobCode, LocalDateTime acceptedDateTime, LocalDateTime completedDateTime,
			LocalDateTime cancelledDateTime, String cancellationReason, String attachments, Review review) {
		super();
		this.id = id;
		this.customer = customer;
		this.handyman = handyman;
		this.serviceCategory = serviceCategory;
		this.description = description;
		this.location = location;
		this.requestedDateTime = requestedDateTime;
		this.status = status;
		this.price = price;
		this.paymentStatus = paymentStatus;
		this.jobCode = jobCode;
		this.acceptedDateTime = acceptedDateTime;
		this.completedDateTime = completedDateTime;
		this.cancelledDateTime = cancelledDateTime;
		this.cancellationReason = cancellationReason;
		this.attachments = attachments;
		this.review = review;
	}

	public Job() {
		super();
	}

	// getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Handyman getHandyman() {
		return handyman;
	}

	public void setHandyman(Handyman handyman) {
		this.handyman = handyman;
	}

	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getRequestedDateTime() {
		return requestedDateTime;
	}

	public void setRequestedDateTime(LocalDateTime requestedDateTime) {
		this.requestedDateTime = requestedDateTime;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public LocalDateTime getAcceptedDateTime() {
		return acceptedDateTime;
	}

	public void setAcceptedDateTime(LocalDateTime acceptedDateTime) {
		this.acceptedDateTime = acceptedDateTime;
	}

	public LocalDateTime getCompletedDateTime() {
		return completedDateTime;
	}

	public void setCompletedDateTime(LocalDateTime completedDateTime) {
		this.completedDateTime = completedDateTime;
	}

	public LocalDateTime getCancelledDateTime() {
		return cancelledDateTime;
	}

	public void setCancelledDateTime(LocalDateTime cancelledDateTime) {
		this.cancelledDateTime = cancelledDateTime;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
    
    
}
