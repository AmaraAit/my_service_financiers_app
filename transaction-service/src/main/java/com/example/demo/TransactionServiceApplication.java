package com.example.demo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Transaction;
import com.example.demo.enumerate.TransactionStatus;
import com.example.demo.enumerate.TransactionType;
import com.example.demo.repository.TransactionRepository;

@SpringBootApplication
@EnableFeignClients
public class TransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(TransactionRepository transactionRepository) {
		return args->{
			Transaction transaction=Transaction.builder()
					.transactionId(1)
					.amount(new BigDecimal(150))
					.sourceAccountId(1)
					.destinationAccountId(2)
					.status(TransactionStatus.COMPLETED)
					.transactionDate(LocalDateTime.now())
					.type(TransactionType.TRANSFER)
					.build();
			Transaction transaction1=Transaction.builder()
					.transactionId(2)
					.amount(new BigDecimal(100))
					.sourceAccountId(1)
					.destinationAccountId(4)
					.status(TransactionStatus.COMPLETED)
					.transactionDate(LocalDateTime.now())
					.type(TransactionType.TRANSFER)
					.build();
			Transaction transaction2=Transaction.builder()
					.transactionId(3)
					.amount(new BigDecimal(150))
					.sourceAccountId(1)
					.destinationAccountId(2)
					.status(TransactionStatus.COMPLETED)
					.transactionDate(LocalDateTime.now())
					.type(TransactionType.TRANSFER)
					.build();
			Transaction transaction3=Transaction.builder()
					.transactionId(4)
					.amount(new BigDecimal(550))
					.sourceAccountId(3)
					.destinationAccountId(5)
					.status(TransactionStatus.COMPLETED)
					.transactionDate(LocalDateTime.now())
					.type(TransactionType.TRANSFER)
					.build();
			Transaction transaction4=Transaction.builder()
					.transactionId(5)
					.amount(new BigDecimal(500))
					.sourceAccountId(4)
					.destinationAccountId(1)
					.status(TransactionStatus.COMPLETED)
					.transactionDate(LocalDateTime.now())
					.type(TransactionType.TRANSFER)
					.build();
			transactionRepository.save(transaction);
			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);
			
		};
	}

}
