package com.example.basicauthentication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthenticationApplication.class, args);
		System.out.println("Hi All my name is saidutt");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
			
	}

}
