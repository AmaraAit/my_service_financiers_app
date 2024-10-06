package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.enumerate.LoanStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class Loan {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private BigDecimal principalAmount;
	private BigDecimal interestRate;
	private int durationInMonths;
	private BigDecimal amount;
	private LocalDateTime loanStartDate;
	private LocalDateTime loanEndDate;
	private BigDecimal outstandingBalance;
	private long userId;
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	@OneToMany(mappedBy = "loan",cascade = CascadeType.ALL)
	private List<LoanPayment> payments;
	
	public BigDecimal calculateTotalInterest() {
		return this.principalAmount.multiply(this.interestRate).divide(BigDecimal.valueOf(100));
	}
	public void approveLoan() {
		this.status=LoanStatus.APPROVED;
		this.loanStartDate=LocalDateTime.now();
		this.loanEndDate=this.loanStartDate.plusMonths(this.durationInMonths);
	}
	public void rejectLoan() {
		this.status=LoanStatus.REJECTED;
	}
	
	
	
	

}
