package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ITransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransactionController {
	
	ITransactionService iTransactionService;

}
