package com.example.basicauthentication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.basicauthentication.dto.UserDto;
import com.example.basicauthentication.entity.UserEntity;
import com.example.basicauthentication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserEntity addUser(UserEntity userEntity) {
	    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
	    

		
		
		userRepository.save(userEntity);
		
		
		return userEntity;
	}

	public List<UserDto> getUsers() {
		List<UserEntity> users = userRepository.findAll();
		
		List<UserDto> userDtos = users.stream().map(user->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}
	

}
