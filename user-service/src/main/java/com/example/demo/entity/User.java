package com.example.demo.entity;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String adresse;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> role = new ArrayList<>();
	
	private boolean enabled;
	
	
	public void activateAccount() {
		this.enabled = true;
	}
	public void desactivateAccount() {
		this.enabled = false;
	}
	

}
