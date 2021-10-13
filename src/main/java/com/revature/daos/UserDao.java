package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	public List<User> findAll();
	public User findUser(String u);
	public boolean addUser(User newUser);
	public boolean changePassword(User u,String newPass);
	//public void changeUsername(String newUserName;)

}
