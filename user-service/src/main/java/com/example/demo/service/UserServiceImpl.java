package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{
	
	private ClientRepository clientRepository;

	@Override
	public Client saveUser(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getUsers() {
		
		return clientRepository.findAll();
	}

	@Override
	public Client getUserByUserId(long userId) {
		
		return clientRepository.findById(userId).get();
	}

	@Override
	public Client updateUser(long userId, Client client) {
		Client u=getUserByUserId(userId);
		u.setFirstName(client.getFirstName());
		u.setLastName(client.getLastName());
		u.setPhoneNumber(client.getPhoneNumber());
		u.setAdresse(client.getAdresse());
		clientRepository.save(u);
		return u;
	}

	@Override
	public void deleteUser(long userId) {
		clientRepository.delete(getUserByUserId(userId));
		
	}

}
