package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.naming.InsufficientResourcesException;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CreateAccountRequestDto;
import com.example.demo.entity.Account;

public interface IAccountService {
	
	List<Account> getAccountsByUserId(long id);
	Account getAccountsById(long id);
	AccountDto createAccountDto(CreateAccountRequestDto accountRequestDto);
	BigDecimal getAccountBalance(long id);
	void debitAccount(long id,BigDecimal amount) throws InsufficientResourcesException;
	void creditAccount(long id, BigDecimal amount);
	List<AccountDto> getAccoutsDtoByUserId(long id);

}
