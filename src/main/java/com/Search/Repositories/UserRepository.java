package com.Search.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Search.Entities.User;



@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
//	public List<User> findByUserNameContainingAndUser(String userName,User user);
	public List<User> findByUserNameContaining(String userName);

}
