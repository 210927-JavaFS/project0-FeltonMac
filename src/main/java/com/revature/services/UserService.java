package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaosImp;
import com.revature.models.User;

public class UserService {
	private UserDao userDao = new UserDaosImp();//prvate or not?

	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	public User findUser(String u){
		return userDao.findUser(u);
	}
	
	public boolean addUser(User newUser) {
	 return userDao.addUser(newUser);
	}

}