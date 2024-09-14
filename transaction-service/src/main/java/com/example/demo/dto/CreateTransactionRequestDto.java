package com.example.demo.dto;

import java.math.BigDecimal;


import com.example.demo.enumerate.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
public class CreateTransactionRequestDto {
	
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private BigDecimal amount;
	private long sourceAccountId;
	private long destinationAccountId;
}
