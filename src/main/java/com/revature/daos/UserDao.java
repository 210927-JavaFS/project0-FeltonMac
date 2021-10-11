package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	public List<User> findAll();
	public User findUser(int id);
	public boolean addUser(User newUser);
	
	//public void changePassword(String newPass);
	//public void changePassword(String newUserName;)

}
