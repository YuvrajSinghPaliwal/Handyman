package com.app.HandyMan.Dtos;

import com.app.HandyMan.Entity.Handyman;

public class HandymanDto {

	private Handyman handyman;
	private String token;
	
	public HandymanDto() {
		super();
	}
	
	public HandymanDto(Handyman handyman, String token) {
		super();
		this.handyman = handyman;
		this.token = token;
	}
	
	public Handyman getHandyman() {
		return handyman;
	}
	public void setHandyman(Handyman handyman) {
		this.handyman = handyman;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
