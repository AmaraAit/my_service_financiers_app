package com.example.demo.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NotificationRequestDto;
import com.example.demo.dto.NotificationResponseDto;
import com.example.demo.enumerate.NotificationType;
import com.example.demo.service.INotificationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
public class NotificationController {
	
	INotificationService iNotificationService;
	
	@GetMapping("/send")
	public ResponseEntity<String> sendNotification( ) {
		NotificationRequestDto request=new NotificationRequestDto();
			request.setMessage("hello there");
			request.setType(NotificationType.EMAIL);
			request.setUserId(1);
	        iNotificationService.sendNotification(request);
	        return ResponseEntity.ok("Notification sent successfully!");
	    }
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<NotificationResponseDto>> getUserNotifications(@PathVariable long userid) {
	        List<NotificationResponseDto> notificationResponseDtos= iNotificationService.getNotificationsForUser(userid);
	        return ResponseEntity.ok(notificationResponseDtos);
	    }
	

}
