package com.example.demo.externe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserDto;

@FeignClient(name = "user-service", url = "http://localhost:8888/USER-SERVICE")
public interface UserClientRest {
	
	@GetMapping("/{id}")
	public  UserDto getUserById(@PathVariable long id);

}
