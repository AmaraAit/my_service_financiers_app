package com.example.demo;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Loan;
import com.example.demo.enumerate.LoanStatus;
import com.example.demo.repository.LoanRepository;

@SpringBootApplication
public class LoanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanServiceApplication.class, args);
	}
	
	  @Bean
	    CommandLineRunner loadData(LoanRepository loanRepository) {
	        return args -> {
	            Loan loan1 = Loan.builder()
	                    .userId(1L)
	                    .amount(new BigDecimal("1000.00"))
	                    .interestRate(new BigDecimal("5.0"))
	                    .durationInMonths(12)
	                    .loanStartDate(LocalDateTime.now())
	                    .loanEndDate(LocalDateTime.now().plusMonths(12))
	                    .outstandingBalance(new BigDecimal("1000.00"))
	                    .status(LoanStatus.APPROVED)
	                    .build();

	            Loan loan2 = Loan.builder()
	                    .userId(2L)
	                    .amount(new BigDecimal("5000.00"))
	                    .interestRate(new BigDecimal("4.5"))
	                    .durationInMonths(24)
	                    .loanStartDate(LocalDateTime.now())
	                    .loanEndDate(LocalDateTime.now().plusMonths(24))
	                    .outstandingBalance(new BigDecimal("5000.00"))
	                    .status(LoanStatus.PENDING)
	                    .build();

	            loanRepository.save(loan1);
	            loanRepository.save(loan2);
	        };
	    }

}
