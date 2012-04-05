package com.mmm.spring.socsec.service;

import java.util.List;

import com.mmm.spring.socsec.entity.User;

public interface UserService {
	User getUserById(String userId);

	String getUserProvider(String userId);
	
	List<User> getAllUsers();
}
