package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.InsufficientResourcesException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CreateAccountRequestDto;
import com.example.demo.entity.Account;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.repository.AccountRepository;

import jakarta.transaction.Transactional;
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
		
		return accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account Not Found"));
	}
	@Override
	public AccountDto createAccountDto(CreateAccountRequestDto accountRequestDto) {
		Account account=new Account();
		account.setUserId(accountRequestDto.getUserId());
		account.setAccountType(accountRequestDto.getAccountType());
		account.setBalance(BigDecimal.ZERO);
		account=accountRepository.save(account);
		return convertToDto(account);
	}
	private AccountDto convertToDto(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setAccountId(account.getAccountId());
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setBalance(account.getBalance());
		accountDto.setUserId(account.getUserId());
		return accountDto;
		
	}
	@Override
	public BigDecimal getAccountBalance(long id) {
		
		return accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found")).getBalance();
	}
	@Override
	@Transactional
	public void debitAccount(long id, BigDecimal amount) throws InsufficientResourcesException {
		Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account Not Found"));
		if(account.getBalance().compareTo(amount)<0) {
			throw new InsufficientResourcesException("Votre credit est insuffisant pour effectué cette transaction");
		}
		account.setBalance(account.getBalance().subtract(amount));
		accountRepository.save(account);
		
	}
	@Override
	@Transactional
	public void creditAccount(long id, BigDecimal amount) {
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not Found"));
		
		account.setBalance(account.getBalance().add(amount));
		accountRepository.save(account);
		
	}
	@Override
	public List<AccountDto> getAccoutsDtoByUserId(long id) {
		List<Account> accounts=accountRepository.findAccountsByUserId(id);
		return accounts.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
