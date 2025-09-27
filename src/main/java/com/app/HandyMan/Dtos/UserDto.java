package com.app.HandyMan.Dtos;

import com.app.HandyMan.Entity.User;

public class UserDto {
	
	private User user;
	private String token;
	
	public UserDto(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	public UserDto() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
