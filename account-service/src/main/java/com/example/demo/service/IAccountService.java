package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface IAccountService {
	
	List<Account> getAccountsByUserId(long id);
	Account getAccountsById(long id);

}
