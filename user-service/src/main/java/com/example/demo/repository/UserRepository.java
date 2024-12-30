package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByFirstName(String username);
	Optional<User> findByEmail(String email);

}
