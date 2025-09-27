package com.app.HandyMan.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.HandyMan.Dtos.UsersRegistrationDto;
import com.app.HandyMan.Entity.User;
import com.app.HandyMan.Repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	     
	     @Autowired
		 private UserRepo userRepository;
	     
	     @Autowired
	     private DtoToEntityMapperService mapper;
	     
	     private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		
		 public List<User> findAll() {
		     return userRepository.findAll();
		 }
		
		 public Optional<User> findById(Long id) {
		     return userRepository.findById(id);
		 }
		
		 public User save(UsersRegistrationDto userDto) {
			    // Check if a user with the same email already exists
			    Optional<User> optional = userRepository.findByEmail(userDto.getEmail());
			    if (optional.isPresent()) {
			        // Return null or throw an exception if user already exists
			        return null;
			    }

			    // Mapping Dto to user 
			    User user=mapper.mapUserDtoToEntity(userDto);

			    // Save the user to the repository
			    return userRepository.save(user);
			}

		
		 public User authenticate(String email, String rawPassword) {
		        return userRepository.findByEmail(email)
		               .filter(users -> encoder.matches(rawPassword, users.getPassword()))
		               .orElse(null);
		    }

		    public User update(User user) {
		        if (!userRepository.existsById(user.getId())) {
		            throw new RuntimeException("User not found with id " + user.getId());
		        }
		        else{
		        	user.setPassword(encoder.encode(user.getPassword()));
		        }
		        return userRepository.save(user);
		    }
		 
		 public void deleteById(Long id) {
		     userRepository.deleteById(id);
		 }
}

