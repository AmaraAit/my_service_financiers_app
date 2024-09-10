package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.enumerate.NotificationType;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class Notification {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 private String message;
	 private LocalDateTime notificationDate;
	 private boolean read;
	 
	 private long userId;
	 @Enumerated(EnumType.STRING)
	 private NotificationType type;
	 
	 public void markAsRead() {
		 this.read=true;
	 }
	 

}
