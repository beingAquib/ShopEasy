package com.example.userManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.userManagement.Entity.User;
import com.example.userManagement.Repository.UserRepository;
import com.example.userManagement.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;
	
	
	  
	 

	public User createUser(User user) {
		
		
		  User u=new User(); u.setFirstName(user.getFirstName()); 
		   
		  u.setPassword(user.getPassword());
		  user.getRoles().forEach(n->u.addRole(n)); u.setEmail(user.getEmail());
		  repo.save(u); return u;
		 
		
		
	}
	
public List<User> getAllUser() {
		
		/*
		 * User u=new User(); u.setFirstName(user.getFirstName()); PasswordEncoder
		 * encoding=encrypt.encodeing(); u.setPassword(
		 * encoding.encode(user.getPassword()));
		 * user.getRoles().forEach(n->u.addRole(n)); u.setEmail(user.getEmail());
		 * repo.save(u); return u;
		 */
	
		List<User> users=repo.findAll();
		
		return users;
	}

public void deleteUser(int id) {
	
	  repo.deleteById(id);
	 
}

@Override
public Page<User> getUserPageWise(int pageNumber) {
	// TODO Auto-generated method stub
	
	Pageable paagable = PageRequest.of(pageNumber, 3);
	Page<User> page=repo.findAll(paagable);
	return page;
	
}
	
	
}
