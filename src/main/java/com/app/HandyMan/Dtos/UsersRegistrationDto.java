package com.app.HandyMan.Dtos;


import com.app.HandyMan.Enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsersRegistrationDto {

	    private String name;

	    @Column(unique = true, nullable = false)
	    private String email;

	    private String phone;
	    private String password;
	    private String profilePicture;
	    private String address;

	    private Boolean isVerified = false;

	    @Enumerated(EnumType.STRING)
	    private UserRole role = UserRole.CUSTOMER;

		public UsersRegistrationDto(String name, String email, String phone, String password, String profilePicture,
				String address, Boolean isVerified, UserRole role) {
			super();
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.password = password;
			this.profilePicture = profilePicture;
			this.address = address;
			this.isVerified = isVerified;
			this.role = role;
		}

		public UsersRegistrationDto() {
			super();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getProfilePicture() {
			return profilePicture;
		}

		public void setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Boolean getIsVerified() {
			return isVerified;
		}

		public void setIsVerified(Boolean isVerified) {
			this.isVerified = isVerified;
		}

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		}
	       
}
