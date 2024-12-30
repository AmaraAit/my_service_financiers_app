package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String adresse;
	private String email;
	private String password;
}
