package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class UserDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String adresse;
	private String email;
	private boolean enabled;
	
	
}
