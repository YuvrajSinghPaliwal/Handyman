package com.app.HandyMan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.HandyMan.Dtos.HandymanRegistrationDto;
import com.app.HandyMan.Dtos.UsersRegistrationDto;
import com.app.HandyMan.Entity.Handyman;
import com.app.HandyMan.Entity.User;
import com.app.HandyMan.Enums.UserRole;

@Component
public class DtoToEntityMapperService {

    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);

    @Autowired
    public DtoToEntityMapperService() {
    }

    public Handyman mapHandymanDtoToEntity(HandymanRegistrationDto dto) {
        Handyman handyman = new Handyman();
        handyman.setName(dto.getName());
        handyman.setContactDetails(dto.getContactDetails());
        handyman.setEmail(dto.getEmail());
        handyman.setPassword(passwordEncoder.encode(dto.getPassword())); // hashed password
        handyman.setProfilePhoto(dto.getProfilePhoto());
        handyman.setExperience(dto.getExperience());
        handyman.setCertifications(dto.getCertifications());
        handyman.setPortfolio(dto.getPortfolio());
        handyman.setAvailability(dto.getAvailability());
        handyman.setLocation(dto.getLocation());

        handyman.setAddressLine(dto.getAddressLine());
        handyman.setCity(dto.getCity());
        handyman.setState(dto.getState());
        handyman.setCountry(dto.getCountry());
        handyman.setPostalCode(dto.getPostalCode());

        handyman.setLatitude(dto.getLatitude() != null ? dto.getLatitude() : 0.0);
        handyman.setLongitude(dto.getLongitude() != null ? dto.getLongitude() : 0.0);

        handyman.setSkills(dto.getSkills());
        handyman.setHourlyRate(dto.getHourlyRate());
        handyman.setVerificationStatus(dto.getVerificationStatus() != null ? dto.getVerificationStatus() : false);
        handyman.setLanguages(dto.getLanguages());

        handyman.setRating(0.0);
        handyman.setEarnings(0.0);
        handyman.setCompletedJobsCount(0);

        return handyman;
    }

    public User mapUserDtoToEntity(UsersRegistrationDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // hashed password
        user.setProfilePicture(dto.getProfilePicture());
        user.setAddress(dto.getAddress());
        user.setIsVerified(dto.getIsVerified() != null ? dto.getIsVerified() : false);
        user.setRole(dto.getRole() != null ? dto.getRole() : UserRole.CUSTOMER);
        user.setWalletBalance(0.0);
        user.setLastLogin(null);
        return user;
    }
}
