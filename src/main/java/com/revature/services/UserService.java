package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaosImp;
import com.revature.models.User;

public class UserService {
	private UserDao userDao = new UserDaosImp();//prvate or not?

	public List<User> getAllUsers(){
		List<User> info=userDao.findAll();
		for (User user : info) {
		user.toString();
		}
		return userDao.findAll();
	}
	
	public User findUser(String u){
		User info=userDao.findUser(u);
		if(info==null) {
			System.out.println("user not found");
			return info;
		}
		info.toString();
		return info;
	}
	
	public boolean addUser(User newUser) {
	 return userDao.addUser(newUser);
	}
	public boolean addCreatedLoginUser(User newuser) {
		return userDao.loginCreateUser(newuser);
	}
	
	
	public User login(String username, String password) {
		User loguser = userDao.findUser(username);
		System.out.println(loguser.toString());
		if (loguser.getUsername()!=null || (loguser.getPassword()!=null)) {
			if(loguser.getPassword().equals(password)){
				return loguser;
			}
		}
		return loguser=null;

	}

	public void changePassword(User u , String passwordchange) {
		userDao.changePassword(u, passwordchange);
		System.out.println(" new password set to "+passwordchange);
	}

}
