package com.app.HandyMan.Entity;


import java.util.ArrayList;
import java.util.List;

import com.app.HandyMan.Config.Auditable;

import jakarta.persistence.*;

@Entity
@Table(name = "handymans")
public class Handyman extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactDetails;
    private String email;
    private String password;
    private String profilePhoto;
    private String experience;
    private String certifications;
    private String portfolio;
    private String availability;
    private String location;
    
    private String addressLine;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    @Column(nullable = false)
    private Double latitude;   // for geo search
    
    @Column(nullable = false)
    private Double longitude;  // for geo search

    private Double rating = 0.0;
    private Double earnings = 0.0;

    private String skills; // comma-separated or JSON
    private Double hourlyRate;
    private Boolean verificationStatus = false;
    private String languages;

    private Integer completedJobsCount = 0;

    @OneToMany(mappedBy = "handyman", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // constructors

	public Handyman(Long id, String name, String contactDetails, String email, String password, String profilePhoto,
			String experience, String certifications, String portfolio, String availability, String location,
			String addressLine, String city, String state, String country, String postalCode, Double latitude,
			Double longitude, Double rating, Double earnings, String skills, Double hourlyRate,
			Boolean verificationStatus, String languages, Integer completedJobsCount, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.contactDetails = contactDetails;
		this.email = email;
		this.password = password;
		this.profilePhoto = profilePhoto;
		this.experience = experience;
		this.certifications = certifications;
		this.portfolio = portfolio;
		this.availability = availability;
		this.location = location;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.earnings = earnings;
		this.skills = skills;
		this.hourlyRate = hourlyRate;
		this.verificationStatus = verificationStatus;
		this.languages = languages;
		this.completedJobsCount = completedJobsCount;
		this.reviews = reviews;
	}

	public Handyman() {
		super();
	}

	//getters and sertters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getEarnings() {
		return earnings;
	}

	public void setEarnings(Double earnings) {
		this.earnings = earnings;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Boolean getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(Boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public Integer getCompletedJobsCount() {
		return completedJobsCount;
	}

	public void setCompletedJobsCount(Integer completedJobsCount) {
		this.completedJobsCount = completedJobsCount;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}