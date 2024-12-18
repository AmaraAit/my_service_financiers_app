package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{
	Optional<Client> findByFirstName(String username);

}
