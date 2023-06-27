package com.example.basicauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor 
@AllArgsConstructor
public class UserDto {
	
	private long id;
	
	private String username;
	
	private String password;

}
