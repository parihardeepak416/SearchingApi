package com.Search.services;

import java.util.List;

import com.Search.Entities.User;

public interface UserService {
	
	//save the user
	public User saveUser(User user);
	
	//update the user
	public User updateUser(User user);
	
	// delete the user
	public String delete(int id);
	
	//getting single user
	public User getUser(int id);
	
	//getting all users
	public List<User> getAllUsers(); 
	
	public List<User> getUserContainingUserName(String userName);

}
