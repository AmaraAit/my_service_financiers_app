package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class NewUserController {
	@Autowired
	AuthenticationManager authenticationManager;
	@GetMapping("/profile")
	public Authentication authentication(Authentication authentication) {
		return authentication;
	}

}
