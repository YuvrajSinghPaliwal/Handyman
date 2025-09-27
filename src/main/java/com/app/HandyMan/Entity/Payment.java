package com.app.HandyMan.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.app.HandyMan.Config.Auditable;
import com.app.HandyMan.Enums.PaymentMethod;
import com.app.HandyMan.Enums.PaymentStatus;

@Entity
@Table(name = "payments")
public class Payment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User payer;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String transactionId;
    private String bankName;
    private String cardLast4;
    private String currency;
    private String gatewayResponse;

    @Enumerated(EnumType.STRING)
    private PaymentStatus refundStatus = PaymentStatus.PENDING;

    private Double refundedAmount = 0.0;
    private String invoiceUrl;
    
    // constructors
    
	public Payment(Long id, User payer, Booking booking, Double amount, PaymentMethod paymentMethod,
			PaymentStatus paymentStatus, String transactionId, String bankName, String cardLast4, String currency,
			String gatewayResponse, PaymentStatus refundStatus, Double refundedAmount, String invoiceUrl) {
		super();
		this.id = id;
		this.payer = payer;
		this.booking = booking;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.bankName = bankName;
		this.cardLast4 = cardLast4;
		this.currency = currency;
		this.gatewayResponse = gatewayResponse;
		this.refundStatus = refundStatus;
		this.refundedAmount = refundedAmount;
		this.invoiceUrl = invoiceUrl;
	}
	public Payment() {
		super();
	}
	
	// getters and setters 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getPayer() {
		return payer;
	}
	public void setPayer(User payer) {
		this.payer = payer;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardLast4() {
		return cardLast4;
	}
	public void setCardLast4(String cardLast4) {
		this.cardLast4 = cardLast4;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getGatewayResponse() {
		return gatewayResponse;
	}
	public void setGatewayResponse(String gatewayResponse) {
		this.gatewayResponse = gatewayResponse;
	}
	public PaymentStatus getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(PaymentStatus refundStatus) {
		this.refundStatus = refundStatus;
	}
	public Double getRefundedAmount() {
		return refundedAmount;
	}
	public void setRefundedAmount(Double refundedAmount) {
		this.refundedAmount = refundedAmount;
	}
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
    
}
