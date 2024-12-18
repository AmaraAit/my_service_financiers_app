package com.example.demo.securite;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.ClientRepository;



@Service

public class AuthenticationService {
	
	private final ClientRepository userRepository;
	private final JwtService jwtService;
	private final BCryptPasswordEncoder passwordEncoder;
	public AuthenticationService(ClientRepository userRepository, JwtService jwtService) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	public String Authenticate(String firstname,String password) {
		Client user = userRepository.findByFirstName(firstname)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
		 String encodedPassword = passwordEncoder.encode(user.getPassword());

		if(user != null && passwordEncoder.matches(password, encodedPassword)) {
			return jwtService.generateToken(firstname);
		}throw new RuntimeException("Nom d'utilisateur ou mot de passe invalide");		
	}
	
	
	

}
