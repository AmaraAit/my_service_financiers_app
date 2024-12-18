package com.example.demo.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateTransactionRequestDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.entity.Transaction;
import com.example.demo.externe.AccountFeignClient;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.ITransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
	TransactionRepository repository;
	ITransactionService iTransactionService;
	AccountFeignClient accountFeignClient;
	
	@PostMapping
	public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody CreateTransactionRequestDto requestDto){
		TransactionResponseDto responseDto = iTransactionService.createTransaction(requestDto);
		return ResponseEntity.ok(responseDto);
		
	}
	@GetMapping
	public List<Transaction> getTransactions(){
		
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public TransactionDto getTransactionById(@PathVariable long id){
		TransactionDto dto=iTransactionService.getTransactionById(id);
				dto.setSourceAccountdto(accountFeignClient.geAccountbyid(dto.getSourceAccountId()));
				dto.setDestinationAccountdto(accountFeignClient.geAccountbyid(dto.getDestinationAccountId()));
		return dto;
	}
	
	@GetMapping("/account/{accountId}")
	public List<TransactionDto> getTransactionForAccount(@PathVariable long accountId){
		List<TransactionDto> transactions=iTransactionService.getTransactionsForAccount(accountId);
		return transactions;
	}
	
}
