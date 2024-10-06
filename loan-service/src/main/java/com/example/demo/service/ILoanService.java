package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LoanDto;

public interface ILoanService {
	
	LoanDto createLoan(LoanDto loanDTO);
	List<LoanDto> getLoansByUserId(Long userId);
	LoanDto getLoanById(Long id);
	void updateLoan(Long id, LoanDto loanDTO);

}
