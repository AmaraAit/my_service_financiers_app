package com.example.demo.entity;


import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class SecurityLog {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String eventDescription;
	private LocalDateTime eventDate;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
}
