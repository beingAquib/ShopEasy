package com.example.userManagement.service;

import java.util.List;

import com.example.userManagement.Entity.User;

public interface UserService {
	
	public User createUser(User user);
	public List<User> getAllUser();
	public void deleteUser(int id);

}
