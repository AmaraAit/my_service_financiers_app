package com.example.demo.entity;



import com.example.demo.enumerate.UserRole;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String adresse;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	private boolean enabled;
	
	
	public void activateAccount() {
		this.enabled = true;
	}
	public void desactivateAccount() {
		this.enabled = false;
	}
	

}
