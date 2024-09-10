package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Loan;
@RepositoryRestResource
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
