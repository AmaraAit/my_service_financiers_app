package com.example.demo.service;

import java.util.List;



import com.example.demo.dto.CreateTransactionRequestDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;

public interface ITransactionService {
	
	TransactionResponseDto createTransaction(CreateTransactionRequestDto transactionRequestDto);
	TransactionDto getTransactionById(long id);
	List<TransactionDto> getTransactionsForAccount(long accountId);

}
