package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class CreateAccountRequestDto {
	
	private long userId;
	private String accountType;
	
	
}
