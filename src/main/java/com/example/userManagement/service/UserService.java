package com.example.userManagement.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.userManagement.Entity.User;

public interface UserService {
	
	public User createUser(User user);
	public List<User> getAllUser();
	public void deleteUser(int id);
	public Page<User> getUserPageWise(int pageNumber);

}
