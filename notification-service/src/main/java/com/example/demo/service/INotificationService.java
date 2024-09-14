package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.NotificationRequestDto;
import com.example.demo.dto.NotificationResponseDto;

public interface INotificationService {
	
	void sendNotification(NotificationRequestDto notificationRequestDto);
	
	List<NotificationResponseDto> getNotificationsForUser(long userId);

}
