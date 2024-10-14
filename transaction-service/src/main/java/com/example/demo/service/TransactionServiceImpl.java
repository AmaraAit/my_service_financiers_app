package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CreateTransactionRequestDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.entity.Transaction;
import com.example.demo.enumerate.TransactionStatus;
import com.example.demo.enumerate.TransactionType;
import com.example.demo.exception.TransactionNotFoundException;
import com.example.demo.externe.AccountFeignClient;
import com.example.demo.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService{
	
	private TransactionRepository transactionRepository;
	private AccountFeignClient accountFeignClient;
	@Override
	@Transactional
	public TransactionResponseDto createTransaction(CreateTransactionRequestDto transactionRequestDto) {
		//verification du solde
		BigDecimal accountBalance= accountFeignClient.getAccountBalance((transactionRequestDto.getSourceAccountId()));
				if(transactionRequestDto.getType().equals(TransactionType.TRANSFER)&&(accountBalance.compareTo(transactionRequestDto.getAmount())<0)) {
					return new TransactionResponseDto(1,TransactionStatus.FAILED,"Solde insuffisant ");
				}
				Transaction transaction= new Transaction();
				transaction.setType(transactionRequestDto.getType());
				transaction.setAmount(transactionRequestDto.getAmount());
				transaction.setSourceAccountId(transactionRequestDto.getSourceAccountId());
				transaction.setDestinationAccountId(transactionRequestDto.getDestinationAccountId());
				transaction.setTransactionDate(LocalDateTime.now());
				transaction.setStatus(TransactionStatus.PENDING);
				transactionRepository.save(transaction);
				
				if(transactionRequestDto.getType().equals(TransactionType.TRANSFER)) {
					accountFeignClient.debitAccount(transactionRequestDto.getSourceAccountId(), transactionRequestDto.getAmount());
				}else {
					accountFeignClient.creditAccount(transactionRequestDto.getDestinationAccountId(), transactionRequestDto.getAmount());
				}
				transaction.setStatus(TransactionStatus.COMPLETED);
				transactionRepository.save(transaction);
		return new TransactionResponseDto(transaction.getTransactionId(),TransactionStatus.COMPLETED,"Transaction est terminée avec succées ");
	}

	@Override
	public TransactionDto getTransactionById(long id) {
		Transaction transaction=transactionRepository.findById(id).orElseThrow(()->new TransactionNotFoundException("Transaction Not Found"));
		
		return convertToDto(transaction);
	}

	@Override
	public List<TransactionDto> getTransactionsForAccount(long accountId) {
		List<Transaction> transactions=transactionRepository.findBySourceAccountIdOrdestinationAccountId(accountId, accountId);
		List<TransactionDto> transactionsdto=new ArrayList<>();
		for (Transaction transaction : transactions) {
			transactionsdto.add(convertToDto(transaction));
		}
		return transactionsdto;
	}
	private TransactionDto convertToDto(Transaction transaction) {
		TransactionDto transactionDto=new TransactionDto();
		transactionDto.setId(transaction.getTransactionId());
		transactionDto.setType(transaction.getType());
		transactionDto.setAmount(transaction.getAmount());
		transactionDto.setSourceAccountId(transaction.getSourceAccountId());
		transactionDto.setDestinationAccountId(transaction.getDestinationAccountId());
		transactionDto.setTransactionDate(transaction.getTransactionDate());
		transactionDto.setStatus(transaction.getStatus());
		return transactionDto;
	}

}
