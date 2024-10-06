package com.example.demo.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoanDto;
import com.example.demo.service.ILoanService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {
	
    private  final ILoanService iLoanService; 
   

    @PostMapping
    public LoanDto createLoan(@RequestBody LoanDto loanDTO) {
        return iLoanService.createLoan(loanDTO);
    }

    @GetMapping("/user/{userId}")
    public List<LoanDto> getLoansByUserId(@PathVariable Long userId) {
        return iLoanService.getLoansByUserId(userId);
    }

    @GetMapping("/{id}")
    public LoanDto getLoanById(@PathVariable Long id) {
        return iLoanService.getLoanById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLoan(@PathVariable Long id, @RequestBody LoanDto loanDTO) {
        iLoanService.updateLoan(id, loanDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
