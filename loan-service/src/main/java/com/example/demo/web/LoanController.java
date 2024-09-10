package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ILoanService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {
	
	ILoanService iLoanService;

}
