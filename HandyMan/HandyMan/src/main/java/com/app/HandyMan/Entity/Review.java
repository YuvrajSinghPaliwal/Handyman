package com.app.HandyMan.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.app.HandyMan.Config.Auditable;

@Entity
@Table(name = "reviews")
public class Review extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handyman_id")
    private Handyman handyman;

    private Integer rating;
    private String comments;
    private String mediaUrls;
    
    // constructors
    
	public Review(Long id, User reviewer, Handyman handyman, Integer rating, String comments, String mediaUrls) {
		super();
		this.id = id;
		this.reviewer = reviewer;
		this.handyman = handyman;
		this.rating = rating;
		this.comments = comments;
		this.mediaUrls = mediaUrls;
	}

	public Review() {
		super();
	}

	// getters and setters 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public Handyman getHandyman() {
		return handyman;
	}

	public void setHandyman(Handyman handyman) {
		this.handyman = handyman;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMediaUrls() {
		return mediaUrls;
	}

	public void setMediaUrls(String mediaUrls) {
		this.mediaUrls = mediaUrls;
	}
    
}