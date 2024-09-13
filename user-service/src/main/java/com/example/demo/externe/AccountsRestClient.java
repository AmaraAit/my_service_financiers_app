package com.example.demo.externe;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.AccountDto;

@FeignClient(name = "ACCOUNT-SERVICE", url = "http://localhost:8888/ACCOUNT-SERVICE/accounts")
public interface AccountsRestClient {
	@GetMapping(name = "/user/{id}")
	List<AccountDto> getAccountsByUserId(@PathVariable long id);
	
	

}
