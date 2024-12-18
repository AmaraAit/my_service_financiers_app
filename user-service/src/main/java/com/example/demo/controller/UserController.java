package com.example.demo.controller;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Client;
import com.example.demo.externe.AccountsRestClient;
import com.example.demo.securite.AuthenticationService;
import com.example.demo.securite.JwtService;
import com.example.demo.service.IUserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
	
	 IUserService iUserService;
	 AccountsRestClient accountsRestClient;
	 private final AuthenticationService authenticationService;
	 private AuthenticationManager authenticationManager;
	 private final JwtService jwtService;
	 
	 @GetMapping("/{id}")
	 public Client getUser(@PathVariable long id) {
		return iUserService.getUserByUserId(id);
		 
	 }
	 @PostMapping("/auth/login")
	 public String login(@RequestParam String  firstName,@RequestParam String password) {
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(firstName, password));
		        

		        return jwtService.generateToken(authentication.getName());
				 
	 }
	 @GetMapping("/accounts/{id}")
	 public List<AccountDto> getAccountsbyUserid(@PathVariable long id) {
		return  accountsRestClient.getAccountsByUserId(id);
		 
	 }
	 @GetMapping
	 public List<Client> getUsers(){
		return iUserService.getUsers();
	 }
	 @PutMapping("/update/{id}")
	 public Client updateUser(@PathVariable long id,@RequestBody Client client) {
		 return iUserService.updateUser(id, client);
	 }
	 @PostMapping("/create")
	 public Client saveUser(@RequestBody Client client) {
		 return iUserService.saveUser(client);
				 
	 }
	 @DeleteMapping("/delete/{id}")
	 public String deleteUser(@PathVariable long id) {
		 iUserService.deleteUser(id);
		return "L'utilisateur "+id+" a été supprimé avec success";
	 }
	 

}
