package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.INotificationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class NotificationController {
	
	INotificationService iNotificationService;

}
