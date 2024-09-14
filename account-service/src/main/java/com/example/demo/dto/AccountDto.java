package com.example.demo.dto;

import java.math.BigDecimal;

import com.example.demo.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class AccountDto {
	private long accountId;
	private long userId;
	private String accountNumber;
	private BigDecimal balance;
	
	
}
