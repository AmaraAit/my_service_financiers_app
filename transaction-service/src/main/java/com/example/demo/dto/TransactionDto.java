package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.enumerate.TransactionStatus;
import com.example.demo.enumerate.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.Data;
@Data
public class TransactionDto {
	
	private long id;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private BigDecimal amount;
	
	private LocalDateTime transactionDate;
	
	
	
	private long sourceAccountId;
	@Transient
	private AccountDTO sourceAccountdto;
	private long destinationAccountId;
	@Transient
	private AccountDTO destinationAccountdto;
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
}
