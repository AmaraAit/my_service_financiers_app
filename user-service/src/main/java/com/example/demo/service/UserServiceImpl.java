package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;


import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService,UserDetailsService{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public User addUser(User client) {
		String pwd=client.getPassword();
		client.setPassword(passwordEncoder.encode(pwd));
		return userRepository.save(client);
	}

	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getById(long userId) {
		
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
	}

	@Override
	public User updateUser(long userId, User client) {
		User u=getById(userId);
		u.setFirstName(client.getFirstName());
		u.setLastName(client.getLastName());
		u.setPhoneNumber(client.getPhoneNumber());
		u.setAdresse(client.getAdresse());
		userRepository.save(u);
		return u;
	}

	@Override
	public void deleteUser(long userId) {
		userRepository.delete(getById(userId));
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByEmail(username).get();
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		user.getRole().forEach(auth->{
			authorities.add(new SimpleGrantedAuthority(auth.getName()));
		});
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
	
		
	

	@Override
	public User getByFirstName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstName(username)
                .orElseThrow(() ->
                new UsernameNotFoundException("User not found with username or email: "+ username));
	}

	@Override
	public User getByEmail(String email) {
		User user =userRepository.findByEmail(email).get();
		return user;
	}

	@Override
	public Role addNewRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public User addRoleToUser(long id, String rolename) {
		User user=getById(id);
		Role role =roleRepository.findByName(rolename);
		user.getRole().add(role);
		userRepository.save(user);
		return user;
	}

	


}
