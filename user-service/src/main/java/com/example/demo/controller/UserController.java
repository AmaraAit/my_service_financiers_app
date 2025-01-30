package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.externe.AccountsRestClient;
import com.example.demo.service.IUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	 IUserService iUserService;
	 AccountsRestClient accountsRestClient;
	 private AuthenticationManager authenticationManager;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 @GetMapping("/{id}")
	 @PreAuthorize("hasAuthority('SCOPE_USER')")
	 public User getUser(@PathVariable long id) {
		return iUserService.getById(id);
		 
	 }
	 @GetMapping("/email/{email}")
	 @PreAuthorize("hasAuthority('SCOPE_USER')")
	 public User getUserbyemail(@PathVariable String email) {
		return iUserService.getByEmail(email);
		 
	 }
	 @GetMapping
	 public User getUserby(Authentication authentication) {
		 User user=iUserService.getByEmail(authentication.getName());
		return user;
		 
	 }
	
	 @PostMapping("/login")
	    public User authenticateUser(@RequestBody LoginDto loginDto){
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsername(), loginDto.getPassword()));
	        System.out.println("amarahbsdddddddddddddddddd");
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return iUserService.getByEmail(loginDto.getUsername());
	    }
	 	
	 	@PostMapping("/signup")
	    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

	        // add check for username exists in a DB
	        if(iUserService.getByFirstName(userDto.getFirstName())!=null){
	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
	        }

	   // add check for email exists in DB
	        

	        // create user object
	        User user = new User();
	        user.setFirstName(userDto.getFirstName());
	        user.setLastName(userDto.getLastName());
	        user.setEmail(userDto.getEmail());
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	        iUserService.addUser(user);
	        iUserService.addRoleToUser(user.getId(), "USER");
	        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

	    }
	 
	 
	 
	 
	 @GetMapping("/accounts/{id}")
	 public List<AccountDto> getAccountsbyUserid(@PathVariable long id) {
		return  accountsRestClient.getAccountsByUserId(id);
		 
	 }
	 @GetMapping("/all")
	 @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	 public List<User> getUsers(){
		return iUserService.getUsers();
	 }
	 @PutMapping("/update/{id}")
	 public User updateUser(@PathVariable long id,@RequestBody User client) {
		 return iUserService.updateUser(id, client);
	 }
	 @PostMapping("/create")
	 public User saveUser(@RequestBody User client) {
		 return iUserService.addUser(client);
				 
	 }
	 @DeleteMapping("/delete/{id}")
	 public String deleteUser(@PathVariable long id) {
		 iUserService.deleteUser(id);
		return "L'utilisateur "+id+" a été supprimé avec success";
	 }
	 

}
