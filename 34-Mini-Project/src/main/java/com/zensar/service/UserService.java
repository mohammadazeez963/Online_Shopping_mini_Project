package com.zensar.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.User;
import com.zensar.db.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	public User addUser(User user) {
		return this.dao.save(user);
	}

	public User removeUser(User user) {
		this.dao.delete(user);
		return user;
	}
}