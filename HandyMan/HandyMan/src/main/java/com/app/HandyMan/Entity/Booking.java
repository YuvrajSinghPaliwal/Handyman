package com.app.HandyMan.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.app.HandyMan.Config.Auditable;
import com.app.HandyMan.Enums.JobStatus;
import com.app.HandyMan.Enums.PaymentMethod;
import com.app.HandyMan.Enums.PaymentStatus;

@Entity
@Table(name = "bookings")
public class Booking extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private LocalDateTime bookingDateTime;
    private Double totalFare;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String transactionId;
    private String bookingCode;
    private String specialInstructions;
    private String discountCode;

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.PENDING;

    // constructors
    
	public Booking(Long id, Job job, LocalDateTime bookingDateTime, Double totalFare, PaymentMethod paymentMethod,
			PaymentStatus paymentStatus, String transactionId, String bookingCode, String specialInstructions,
			String discountCode, JobStatus status) {
		super();
		this.id = id;
		this.job = job;
		this.bookingDateTime = bookingDateTime;
		this.totalFare = totalFare;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.bookingCode = bookingCode;
		this.specialInstructions = specialInstructions;
		this.discountCode = discountCode;
		this.status = status;
	}

	public Booking() {
		super();
	}

	// getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}
    
}
