package com.Search.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Search.Entities.User;
import com.Search.Repositories.UserRepository;
import com.Search.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(@RequestBody User user) {
		
		int id = user.getId();
		String phone = user.getPhone();
		Optional<User> optional = userRepository.findById(id);
		User databaseUser = optional.get();
		databaseUser.setPhone(phone);
		return databaseUser;
	}

	@Override
	public String delete(int id) {
		Optional<User> optional = userRepository.findById(id);
		User user = optional.get();
		userRepository.delete(user);
		return "user deleted successfully";
	}

	@Override
	public User getUser(int id) {
		Optional<User> optional = userRepository.findById(id);
		User user = optional.get();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public List<User> getUserContainingUserName(String userName) {
		
		List<User> byUserNameContaining = userRepository.findByUserNameContaining(userName);
		return byUserNameContaining;
	}
	
	

}
