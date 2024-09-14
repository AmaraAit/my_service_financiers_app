package com.example.demo.externe;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountFeignClient {
	@GetMapping("/accounts/{id}/balance")
	BigDecimal getAccountBalance(@PathVariable long id);
	
	@PostMapping("/accounts/{accountId}/debit")
	void debitAccount(@PathVariable long accountId,@RequestParam BigDecimal amount);
	
	@PostMapping("/accounts/{accountId}/credit")
	void creditAccount(@PathVariable long accountId,@RequestParam BigDecimal amount);
	
	

}
