package com.app.HandyMan.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	  http
    	  .cors(Customizer.withDefaults())
          .csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(auth -> auth
              .requestMatchers(
                  "api/users/login", "api/users/register", 
                  "api/handymen/login", "api/handymen/register", 
                  "/swagger-ui/**", "/v3/api-docs/**",
                  "/swagger-resources/**", "/webjars/**")
              .permitAll()
              .anyRequest().authenticated()
          )
          .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
          .formLogin(AbstractHttpConfigurer::disable);

      return http.build();
    }
}



