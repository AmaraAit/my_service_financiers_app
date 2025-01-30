package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(AccountRepository accountRepository) {
		
		return args->{
			List<Account> accounts=List.of(
					Account.builder()
						.accountNumber("0000212230001")
						.accountType("Eparge")
						.balance(new BigDecimal(1000))
						.userId(1)
						.build(),
					Account.builder()
						.accountNumber("0000212643201")
						.accountType("Eparge")
						.balance(new BigDecimal(2143))
						.userId(2)
						.build(),
					Account.builder()
						.accountNumber("0987812230001")
						.accountType("Eparge")
						.balance(new BigDecimal(3454))
						.userId(3)
						.build(),
					Account.builder()
						.accountNumber("000987643201")
						.accountType("COURANT")
						.balance(new BigDecimal(4533))
						.userId(4)
						.build(),
					Account.builder()
						.accountNumber("0000212230001")
						.accountType("Eparge")
						.balance(new BigDecimal(1000))
						.userId(5)
						.build(),
					Account.builder()
						.accountNumber("0989565689")
						.accountType("COURANT")
						.balance(new BigDecimal(2143))
						.userId(6)
						.build(),
					Account.builder()
						.accountNumber("0987882239801")
						.accountType("COURANT")
						.balance(new BigDecimal(3454))
						.userId(7)
						.build(),
					Account.builder()
						.accountNumber("00765743201")
						.accountType("COURANT")
						.balance(new BigDecimal(657))
						.userId(8)
						.build()
					);
			accountRepository.saveAll(accounts);
			
		};
		
	}

}
