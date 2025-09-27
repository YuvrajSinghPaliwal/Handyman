package com.app.HandyMan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HandyManApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandyManApplication.class, args);
	}

}
