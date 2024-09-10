package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IAccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {
	
	IAccountService accountService;

}
