package com.app.HandyMan.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.HandyMan.Dtos.HandymanDto;
import com.app.HandyMan.Dtos.HandymanLoginDto;
import com.app.HandyMan.Dtos.HandymanRegistrationDto;
import com.app.HandyMan.Dtos.UserDto;
import com.app.HandyMan.Dtos.UsersLoginDto;
import com.app.HandyMan.Dtos.UsersRegistrationDto;
import com.app.HandyMan.Entity.Handyman;
import com.app.HandyMan.Entity.User;
import com.app.HandyMan.Service.HandymanService;
import com.app.HandyMan.Service.JwtService;
import com.app.HandyMan.Service.UserService;


@RestController
@RequestMapping("/api")
public class SecurityController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HandymanService handymanService;
	
	@Autowired 
	private JwtService jwtService;
	
	
	// user login
	
	@PostMapping("/users/login")
	public ResponseEntity<UserDto> usersLogin(@RequestBody UsersLoginDto login){
		
		User user=userService.authenticate(login.getEmail(), login.getPassword());
		if(user==null) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(new UserDto(user,jwtService.generateToken(user.getEmail())),HttpStatus.OK);
	}
	
	// handyman login
	
	@PostMapping("/handymen/login")
	public ResponseEntity<HandymanDto> handymanLogin(@RequestBody HandymanLoginDto login){
		
		Handyman handyman=handymanService.authenticate(login.getEmail(), login.getPassword());
		if(handyman==null) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(new HandymanDto(handyman,jwtService.generateToken(handyman.getEmail())),HttpStatus.OK);
	}
	
	// user register
	
	@PostMapping("/users/register")
    public ResponseEntity<UserDto> usersRegistration(@RequestBody UsersRegistrationDto userDto){
		
		User user=userService.save(userDto);
		if(user==null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new UserDto(user,jwtService.generateToken(user.getEmail())),HttpStatus.OK);
	}
	// handyman register
	
	@PostMapping("/handymen/register")
    public ResponseEntity<HandymanDto> handymanRegistration(@RequestBody HandymanRegistrationDto handymanDto){
		
		Handyman handyman=handymanService.save(handymanDto);
		if(handyman==null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new HandymanDto(handyman,jwtService.generateToken(handyman.getEmail())),HttpStatus.OK);
	}
	
}
