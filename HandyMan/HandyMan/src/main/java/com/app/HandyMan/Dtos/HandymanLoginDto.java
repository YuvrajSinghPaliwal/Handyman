package com.app.HandyMan.Dtos;

public class HandymanLoginDto {

	
	private String email;
	private String password;
	
	public HandymanLoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public HandymanLoginDto() {
		super();
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
