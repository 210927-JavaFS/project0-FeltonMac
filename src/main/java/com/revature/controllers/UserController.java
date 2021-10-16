package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.services.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;



public class UserController {
	
	private  UserService userService = new UserService();
	private  Scanner scan = new Scanner(System.in);
	String response;
	public void userMenu(User user){
		// menu selection
		do {
		System.out.println("       User menu ");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("1) See User info");
		System.out.println("2) change password");
		System.out.println("3) add user");
		System.out.println("0) EXIT");
		response = scan.nextLine();
		switch(response) {
		case "1":
			System.out.println("checking user info ");
			displayOneUser( user.getUsername());
			System.out.println("user info complete ");
			break;
		case "2":
			System.out.println("changing password");
			System.out.println("What would you like to change it too");
			String passwordchange=scan.nextLine();
			userService.changePassword(user,passwordchange);// make sure it changed in data base
			user.setPassword(passwordchange);
			System.out.println("Complete");
			break;
		case "3":
			if(user.getAccesslevel().equals("two") || user.getAccesslevel().equals("three") ) {
				System.out.println("Enter user info");
				User newuser= new User();
				System.out.println("Enter User Name");
				newuser.setUsername( scan.nextLine());
				System.out.println("Enter password");
				newuser.setPassword( scan.nextLine());
				System.out.println("Enter access level");
				newuser.setAccesslevel(scan.nextLine());
				System.out.println("Enter account number");
				BankAccount BA=new BankAccount(scan.nextLine(), 0.00);
				newuser.setAccount(BA);
				userService.addUser(newuser);
				System.out.println("Info sent");		
			}
			System.out.println("not proper Access level");
			break;
		case "0":
			break;
		}
	}while(response!="0");
	}
	
	
	public void getAllUsers(){
		System.out.println("These are your homes:");
		List<User> list = userService.getAllUsers();
		for(User user:list) {
			System.out.println(user);
		}
	}

	public void displayOneUser(String username) {
		System.out.println(" User "+username+":");
		User user = userService.findUser(username);
		System.out.println(user.toString());
	}
	
	
	public void addUser() {
		System.out.println("*---------------------*");
		System.out.println("What is the user name?");
		String username = scan.nextLine();
		System.out.println("*---------------------*");
		System.out.println(" what is the password ?");
		String password = scan.nextLine();
		System.out.println("*---------------------*");
		System.out.println("what is Access level ");
		String accesslevel = scan.nextLine();
		User user = new User(username, password, accesslevel);
		
		if(userService.addUser(user)){
			System.out.println("successfully created");
		}else {
			System.out.println("Something went wrong. Please try again.");
		}
	}
	public User newUserMenu() {
		User newUser= new User();
		System.out.println("*---------------------*");
		System.out.println("What is the user name?");
		String username = scan.nextLine();
		System.out.println("*---------------------*");
		System.out.println(" what is the password ?");
		String password = scan.nextLine();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setAccesslevel("one");
		return newUser;
	}

}
