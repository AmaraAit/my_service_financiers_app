package com.example.demo.web;

import java.math.BigDecimal;
import java.util.List;

import javax.naming.InsufficientResourcesException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CreateAccountRequestDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Account;
import com.example.demo.externe.UserClientRest;
import com.example.demo.service.IAccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	IAccountService accountService;
	UserClientRest clientRest;
	
	@PostMapping
	public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequestDto createAccountRequestDto){
		AccountDto accountDto=accountService.createAccountDto(createAccountRequestDto);
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping("/{accountId}/balance")
	public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable long accountId){
		BigDecimal balance=accountService.getAccountBalance(accountId);
		return ResponseEntity.ok(balance);
	}
	@PostMapping("/{accountId}/debit")
	public ResponseEntity<String> debitAccount(@PathVariable long accountId,@RequestParam BigDecimal amount) throws InsufficientResourcesException {
		accountService.debitAccount(accountId, amount);
		return ResponseEntity.ok("Account Debited Sucessfully");
	}
	@PostMapping("/{accountId}/credit")
	public ResponseEntity<String> creditAccount(@PathVariable long accountId,@RequestParam BigDecimal amount) throws InsufficientResourcesException {
		accountService.creditAccount(accountId, amount);
		return ResponseEntity.ok("Account credited Sucessfully");
	}
	
	@GetMapping("/auth")
	public Authentication authentication(Authentication authentication) {
		
		return authentication;
	}

	@GetMapping("/{id}")
	public Account geAccountbyid(@PathVariable long id) {
		Account account=accountService.getAccountsById(id);
			account.setUserDto(clientRest.getUserById(account.getUserId()));
		
		return account;
	}
	
	@GetMapping("/users/{id}")
	public UserDto createAccount(@PathVariable long id) {
		
		return clientRest.getUserById(id);
	}
	@GetMapping("/user/{id}")
	public List<AccountDto> getAccountsByUserId(@PathVariable long id) {
		List<AccountDto> accountDtos=accountService.getAccoutsDtoByUserId(id);
		return accountDtos;
	}
	
	

}
