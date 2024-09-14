package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.enumerate.TransactionStatus;
import com.example.demo.enumerate.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
public class TransactionDto {
	
	private long id;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private BigDecimal amount;
	
	private LocalDateTime transactionDate;
	
	
	
	private long sourceAccountId;
	
	private long destinationAccountId;
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
}
