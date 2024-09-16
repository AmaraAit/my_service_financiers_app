package com.example.demo.externe;



import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "user-service", url = "http://localhost:8888/USER-SERVICE")
@RefreshScope
public interface UserClientRest {
	
	@GetMapping("/{id}")
	@CircuitBreaker(name = "user-service",fallbackMethod = "getDefaultUser")
    UserDto getUserById(@PathVariable long id);
	
	  default UserDto  getDefaultUser() {
		UserDto userDto=new UserDto();
		userDto.setFirstName("Not Available");
		userDto.setLastName("Not Available");
		userDto.setAdresse("Not Available");
		userDto.setEmail("Not Available");
		userDto.setPhoneNumber(0);
		userDto.setId(0);
		userDto.setEnabled(false);
		
		return userDto;
	}
	

}
