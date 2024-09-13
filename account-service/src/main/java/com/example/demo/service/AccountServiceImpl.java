package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService{

	AccountRepository accountRepository;
	@Override
	public List<Account> getAccountsByUserId(long id) {
		
		return accountRepository.findAccountsByUserId(id);
	}
	@Override
	public Account getAccountsById(long id) {
		
		return accountRepository.findById(id).get();
	}

}
