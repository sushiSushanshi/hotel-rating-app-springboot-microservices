package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u1 = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> usersList =  userService.getAllUsers();
		
		return ResponseEntity.ok(usersList);
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<User> getUserById(@PathVariable String user_id){
		User u1 = userService.getUserById(user_id);
		return ResponseEntity.ok(u1);
	}
	
	
}
