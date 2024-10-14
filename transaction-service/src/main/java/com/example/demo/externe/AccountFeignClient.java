package com.example.demo.externe;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AccountDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountFeignClient {
	@GetMapping("/accounts/{id}/balance")
	@CircuitBreaker(name = "ACCOUNT-SERVICE",fallbackMethod = "getDefaultBalance")
	BigDecimal getAccountBalance(@PathVariable long id);
	
	@PostMapping("/accounts/{accountId}/debit")
	@CircuitBreaker(name = "ACCOUNT-SERVICE",fallbackMethod = "getDefaultInfo")
	void debitAccount(@PathVariable long accountId,@RequestParam BigDecimal amount);
	
	@PostMapping("/accounts/{accountId}/credit")
	@CircuitBreaker(name = "ACCOUNT-SERVICE",fallbackMethod = "getDefaultInfo")
	void creditAccount(@PathVariable long accountId,@RequestParam BigDecimal amount);
	
	@GetMapping("/accounts/{id}")
	@CircuitBreaker(name = "ACCOUNT-SERVICE",fallbackMethod = "getDefaultAccount")
    AccountDTO geAccountbyid(@PathVariable long id);
	
	default BigDecimal getDefaultBalance(long id,Exception exception) {
		
		return new BigDecimal(0);
		
	}
	default String getDefaultInfo(long id,Exception exception) {
		
		return "Opération Echoué";
		
	}
	default AccountDTO getDefaultAccount(long id,Exception exception) {
		AccountDTO accountDTO=AccountDTO.builder()
				.accountId(id)
				.accountNumber("Not Available")
				.accountType("Not Available")
				.balance(null)
				.build();
		return accountDTO;
		
	}
	

}
