package com.example.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Account;
import com.example.demo.externe.UserClientRest;
import com.example.demo.service.IAccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
	
	IAccountService accountService;
	UserClientRest clientRest;
	
	
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		return null;
	}
	
	@GetMapping("/{id}")
	public Account geAccountbyid(@PathVariable long id) {
		Account account=accountService.getAccountsById(id);
			account.setUserDto(clientRest.getUserById(id));
		
		return account;
	}
	
	@GetMapping("/users/{id}")
	public UserDto createAccount(@PathVariable long id) {
		
		return clientRest.getUserById(id);
	}
	@GetMapping("/user/{id}")
	public List<Account> getAccountsByUserId(@PathVariable long id) {
		
		return accountService.getAccountsByUserId(id);
	}
	
	

}
