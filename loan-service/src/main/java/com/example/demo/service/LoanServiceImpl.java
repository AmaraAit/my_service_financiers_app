package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoanDto;
import com.example.demo.entity.Loan;
import com.example.demo.enumerate.LoanStatus;
import com.example.demo.exception.LoanNotFoundException;
import com.example.demo.repository.LoanRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService{
	private final LoanRepository loanRepository;
	public LoanDto createLoan(LoanDto loanDTO) {
        Loan loan = Loan.builder()
                .userId(loanDTO.getUserId())
                .amount(loanDTO.getAmount())
                .interestRate(loanDTO.getInterestRate())
                .durationInMonths(loanDTO.getDurationInMonths())
                .loanStartDate(loanDTO.getLoanStartDate())
                .loanEndDate(loanDTO.getLoanEndDate())
                .outstandingBalance(loanDTO.getOutstandingBalance())
                .status(LoanStatus.PENDING)
                .build();

        loan = loanRepository.save(loan);
        return mapToDTO(loan);
    }

    public List<LoanDto> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public LoanDto getLoanById(Long id) {
        return loanRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(()-> new LoanNotFoundException("Loan Not Found"));
                
    }

    public void updateLoan(Long id, LoanDto loanDTO) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));

        loan.setOutstandingBalance(loanDTO.getOutstandingBalance());
        loan.setStatus(loanDTO.getStatus());
        loanRepository.save(loan);
    }

    private LoanDto mapToDTO(Loan loan) {
        return LoanDto.builder()
                .id(loan.getId())
                .userId(loan.getUserId())
                .amount(loan.getAmount())
                .interestRate(loan.getInterestRate())
                .durationInMonths(loan.getDurationInMonths())
                .loanStartDate(loan.getLoanStartDate())
                .loanEndDate(loan.getLoanEndDate())
                .outstandingBalance(loan.getOutstandingBalance())
                .status(loan.getStatus())
                .build();
    }

}
