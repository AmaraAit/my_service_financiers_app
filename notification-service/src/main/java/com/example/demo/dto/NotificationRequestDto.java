package com.example.demo.dto;


import com.example.demo.enumerate.NotificationType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class NotificationRequestDto {
	 
	 private long userId;
	 private String message;
	 @Enumerated(EnumType.STRING)
	 private NotificationType type;

}
