package com.Search.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Search.Entities.User;
import com.Search.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping
	public ResponseEntity<User> savEntity(@RequestBody User user)
	{
		User saveUser = userServiceImpl.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@PutMapping
	public ResponseEntity<User> updateEntity(User user)
	{
		User updateUser = userServiceImpl.updateUser(user);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEntity(@PathVariable int id)
	{
		String deletedString = userServiceImpl.delete(id);
		return ResponseEntity.ok(deletedString);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getEntity(@PathVariable int id) 
	{
		User user = userServiceImpl.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllEntity()
	{
		List<User> allUsers = userServiceImpl.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/search/{userName}")
	public ResponseEntity<List<User>> searchUser(@PathVariable String userName)
	{
		List<User> userContainingUserName = userServiceImpl.getUserContainingUserName(userName);
		return ResponseEntity.ok(userContainingUserName);
	}
	
	
	
	
	
	
	
	
	
	
}
