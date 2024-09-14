package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NotificationRequestDto;
import com.example.demo.dto.NotificationResponseDto;
import com.example.demo.entity.Notification;
import com.example.demo.enumerate.NotificationType;
import com.example.demo.repository.NotificationRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class NotificationServiceImpl implements INotificationService{
	private NotificationRepository notificationRepository;
	 private JavaMailSender mailSender;

	    public void sendSimpleEmail(String to, String subject, String text) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("aitmatenamara.12@gmail.com");
	        message.setSubject(subject);
	        message.setText(text);
	        message.setFrom("aitmatenamara.12@gmail.com");  // Remplacez par votre adresse email

	        mailSender.send(message);
	        System.out.println("Mail sent successfully to " + to);
	    }
	
	@Override
	public void sendNotification(NotificationRequestDto notificationRequestDto) {
		Notification notification=new Notification();
		notification.setId(1);
		notification.setUserId(notificationRequestDto.getUserId());
		notification.setMessage(notificationRequestDto.getMessage());
		notification.setType(notificationRequestDto.getType());
		notification.setNotificationDate(LocalDateTime.now());
		notification.markAsRead();
		notificationRepository.save(notification);
		if(notification.getType().equals(NotificationType.EMAIL)) {
			sendSimpleEmail("dddddddddd", "send mssg", notification.getMessage());
		}else if(notification.getType().equals(NotificationType.SMS)) {
			sendSmsNotification( notificationRequestDto);
		}else if(notification.getType().equals(NotificationType.PUSH)) {
			sendPushNotification( notificationRequestDto);
		}
		
	}

	private void sendPushNotification(NotificationRequestDto notificationRequestDto) {
		System.out.println("sending push to userid = "+notificationRequestDto.getUserId());
		
	}

	private void sendSmsNotification(NotificationRequestDto notificationRequestDto) {
		System.out.println("sending sms to userid = "+notificationRequestDto.getUserId());
		
	}

	private void sendEmailNotification(NotificationRequestDto notificationRequestDto) {
		
		System.out.println("sending email to userid = "+notificationRequestDto.getUserId());
		
	}

	@Override
	public List<NotificationResponseDto> getNotificationsForUser(long userId) {
		List<Notification> notifications=notificationRepository.findByUserId(userId);
		return notifications.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	private NotificationResponseDto convertToDto(Notification notification) {
		NotificationResponseDto notificationResponseDto=new NotificationResponseDto();
		notificationResponseDto.setId(notification.getId());
		notificationResponseDto.setMessage(notification.getMessage());
		notificationResponseDto.setType(notification.getType());
		notificationResponseDto.setUserId(notification.getUserId());
		notificationResponseDto.setNotificationDate(notification.getNotificationDate());
		return notificationResponseDto;
		
	}

}
