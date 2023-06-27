package com.example.basicauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
	
	

//  @Bean
//  public UserDetailsService userDetailsService(){
//
//    UserDetails user = UserDto.builder().username("saidutt").password(passwordEncoder().encode("Sonu@1234")).roles("ADMIN").build();
//    UserDetails user1 = UserDto.builder().username("preetham").password(passwordEncoder().encode("Preetham@1234")).roles("ADMIN").build();
//
//    return new InMemoryUserDetailsManager(user,user1);
//  }


  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  
}