package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.LoanPayment;
import com.example.demo.enumerate.LoanStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
	private long id;
	private long userId;
	private BigDecimal amount;
	private BigDecimal interestRate;
	private int durationInMonths;
	private LocalDateTime loanStartDate;
	private LocalDateTime loanEndDate;
	private BigDecimal outstandingBalance;
	@Enumerated(EnumType.STRING)
	private LoanStatus status;

}
