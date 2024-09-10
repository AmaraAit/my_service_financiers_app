package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.service.IUserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class UserController {
	
	 IUserService iUserService;
	 
	 @GetMapping("/{id}")
	 public Client getUser(@PathVariable String id) {
		return iUserService.getUserByUserId(id);
		 
	 }
	 @GetMapping
	 public List<Client> getUsers() {
		return iUserService.getUsers();
		 
	 }
	 @PutMapping("/update/{id}")
	 public Client updateUser(@PathVariable String id,@RequestBody Client client) {
		 return iUserService.updateUser(id, client);
	 }
	 @PostMapping("/create")
	 public Client saveUser(@RequestBody Client client) {
		 return iUserService.saveUser(client);
				 
	 }
	 @DeleteMapping("/delete/{id}")
	 public String deleteUser(@PathVariable String id) {
		 iUserService.deleteUser(id);
		return "L'utilisateur "+id+" a été supprimé avec success";
	 }
	 

}
