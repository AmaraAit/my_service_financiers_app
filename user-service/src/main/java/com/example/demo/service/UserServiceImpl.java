package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{
	
	private UserRepository userRepository;

	@Override
	public Client saveUser(Client client) {
		
		return userRepository.save(client);
	}

	@Override
	public List<Client> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public Client getUserByUserId(String userId) {
		
		return userRepository.findById(userId).get();
	}

	@Override
	public Client updateUser(String userId, Client client) {
		Client u=getUserByUserId(userId);
		u.setFirstName(client.getFirstName());
		u.setLastName(client.getLastName());
		u.setPhoneNumber(client.getPhoneNumber());
		u.setAdresse(client.getAdresse());
		userRepository.save(u);
		return u;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.delete(getUserByUserId(userId));
		
	}

}
