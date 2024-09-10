package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.enumerate.PaymentStatus;

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
public class LoanPayment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private BigDecimal paymentAmount;
	private LocalDateTime paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

}
