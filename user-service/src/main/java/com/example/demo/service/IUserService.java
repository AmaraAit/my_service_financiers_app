package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Client;

public interface IUserService {
	
	Client saveUser(Client client);
	List<Client> getUsers();
	Client getUserByUserId(long userId);
	Client updateUser(long userId,Client client);
	void deleteUser(long userId);

}
