package com.example.basicauthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.basicauthentication.entity.UserEntity;
import com.example.basicauthentication.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserEntity user = userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User Not Found"));
    
    //load user from database

    return user;
  }
}
