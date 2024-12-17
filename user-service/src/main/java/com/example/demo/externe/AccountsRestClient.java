package com.example.demo.externe;

import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.AccountDto;

@FeignClient(name = "ACCOUNT-SERVICE")
@RefreshScope
public interface AccountsRestClient {
	
	//@CircuitBreaker(name = "ACCOUNT-SERVICE",fallbackMethod = "getDefaultAccount")
	@GetMapping("/accounts/user/{id}")
	List<AccountDto> getAccountsByUserId(@PathVariable long id);
	
	

}
