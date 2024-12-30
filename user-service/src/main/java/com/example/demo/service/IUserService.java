package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface IUserService {
	
	User addUser(User client);
	List<User> getUsers();
	User getById(long userId);
	User getByFirstName(String firstname);
	User getByEmail(String email);
	Role addNewRole(Role role);
	User addRoleToUser(long id,String rolename);
	User updateUser(long userId,User client);
	void deleteUser(long userId);

}
