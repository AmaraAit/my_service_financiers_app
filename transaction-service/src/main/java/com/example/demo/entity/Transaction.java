package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.example.demo.enumerate.TransactionStatus;
import com.example.demo.enumerate.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	private BigDecimal amount;
	private LocalDateTime transactionDate;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	private long sourceAccountId;
	
	private long destinationAccountId;
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
	
	public void completeTransaction() {
		this.status = TransactionStatus.COMPLETED;
	}
	public void failTransaction() {
		this.status = TransactionStatus.FAILED;
	}

}
