package com.app.HandyMan.Entity;

import java.time.LocalDateTime;

import com.app.HandyMan.Config.Auditable;
import com.app.HandyMan.Enums.UserRole;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ADMIN;

    private Boolean active = true;
    private LocalDateTime lastLogin;
    
    // constructors
    
	public Admin(Long id, String username, String password, String email, UserRole role, Boolean active,
			LocalDateTime lastLogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.active = active;
		this.lastLogin = lastLogin;
	}
	
	public Admin() {
		super();
	}
	
	// getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
    
}
