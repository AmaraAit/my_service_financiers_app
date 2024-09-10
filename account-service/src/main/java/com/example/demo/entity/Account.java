package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder 
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	private String accountNumber;
	private String accountType;
	private BigDecimal balance;
	
	private long userId;
	
	
	public void deposit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}
	
	public void withdraw(BigDecimal amount){
		if(this.balance.compareTo(amount)>=0) {
			this.balance=this.balance.subtract(amount);
		}
	}

}