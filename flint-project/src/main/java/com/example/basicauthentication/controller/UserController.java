package com.example.basicauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicauthentication.config.SecurityConfig;
import com.example.basicauthentication.dto.UserDto;
import com.example.basicauthentication.entity.UserEntity;
import com.example.basicauthentication.service.CustomUserDetailService;
import com.example.basicauthentication.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailService userDetailsService;
	
	@Autowired
	private SecurityConfig securityConfig;
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping("/login")
	  public ResponseEntity<String> login(@RequestBody UserEntity userEntity) {

	    //this.doAuthenticate(userEntity.getUsername(), userEntity.getPassword());

	    UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getUsername());
	    
	    System.out.println(userDetails.getPassword());
	    System.out.println(userEntity.getPassword());
	    
	    
	    String str1 = userDetails.getPassword();
	    String str2 = userEntity.getPassword();
	    
	    System.out.println();
	    
	    System.out.println(str1);
	    System.out.println(str2);
	    
	    if(passwordEncoder.matches(str2, str1)) {
	    	 return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
	    	
	    } else {
	    	 return new ResponseEntity<>("Passwords does not match", HttpStatus.BAD_REQUEST);
	    }

	    
	    
	     /*if(str1.equals(str2)) {
	    	 return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
	     } else 
	     {
	    	 return new ResponseEntity<>("Passwords does not match[", HttpStatus.OK);
	     }*/
	     
    	 

	    
	    /*if(userDetails != null) {
	    	
	    }*/

	    
	  }
	
	  /*private void doAuthenticate(String email, String password) {

		    UsernamePasswordAuthenticationToken
		        authentication = new UsernamePasswordAuthenticationToken(email, password);
		    try {
		      manager.authenticate(authentication);


		    } catch (BadCredentialsException e) {
		      throw new BadCredentialsException(" Invalid Username or Password  !!");
		    }

		  }*/
	  
	  /*@ExceptionHandler(BadCredentialsException.class)
	  public String exceptionHandler() {
	    return "Credentials Invalid !!";
	  }*/
	
	@PostMapping("/create-user")
	  public UserEntity createUser(@RequestBody UserEntity user){
	    return userService.addUser(user);
	  }
	
	@GetMapping("/getUsers")
	public List<UserDto> getUsers(){
		return userService.getUsers();
	}
	
	

}
