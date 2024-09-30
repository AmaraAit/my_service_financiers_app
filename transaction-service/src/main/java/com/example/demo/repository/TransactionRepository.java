package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Transaction;
@RepositoryRestResource
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query(
			  value = "SELECT * FROM Transaction u WHERE u.source_account_id = ?1 or u.destination_account_id= ?2", 
			  nativeQuery = true)
	List<Transaction> findBySourceAccountIdOrdestinationAccountId(long fromAccountId, long toAccountId);

}
