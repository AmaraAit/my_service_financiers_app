package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Notification;
@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	List<Notification> findByUserId(long userid);

}
