package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	User addUser(User user);
	List<User> getAllUsers();
	User getUserById(String user_id);
	void deleteUserbyId(String user_id);
	User updateUserById(String user_id);
	
}
