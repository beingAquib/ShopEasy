package com.example.userManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userManagement.Entity.User;
import com.example.userManagement.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;

	
	@PostMapping("create")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return new ResponseEntity<User>(service.createUser(user),HttpStatus.CREATED);
		
	}
	
	@GetMapping("allUser")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> users=service.getAllUser();
		return new ResponseEntity<List<User>>(users,HttpStatus.FOUND);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		service.deleteUser(id);
		return new ResponseEntity<String>("Id "+id+" is deleted.",HttpStatus.OK);
	}
	@GetMapping("getPage/{pageId}")
	public ResponseEntity<Page<User>> getUserByPage(@PathVariable int pageId){
		Page<User> user=service.getUserPageWise(pageId);
		return new ResponseEntity<Page<User>>(user,HttpStatus.OK);
	}
	
}
