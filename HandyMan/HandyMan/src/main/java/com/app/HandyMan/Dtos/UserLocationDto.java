package com.app.HandyMan.Dtos;

public class UserLocationDto {
    private Double latitude;   // 🌍 For location search
    private Double longitude;  // 🌍 For location search
    
	public UserLocationDto(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public UserLocationDto() {
		super();
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
    
    
	
}
