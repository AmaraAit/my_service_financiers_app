package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Client;

public interface IUserService {
	
	Client saveUser(Client client);
	List<Client> getUsers();
	Client getUserByUserId(String userId);
	Client updateUser(String userId,Client client);
	void deleteUser(String userId);

}
