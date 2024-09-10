package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Account;
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long>{

}
