package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.entity.Transaction;
import com.example.demo.enumerate.TransactionStatus;
import com.example.demo.enumerate.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class AccountDTO {
	
	private long accountId;
	private String accountNumber;
	private String accountType;
	private BigDecimal balance;
	
	private long userId;

}
