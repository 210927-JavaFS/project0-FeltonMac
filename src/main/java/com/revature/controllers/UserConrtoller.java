package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;



public class UserConrtoller {
	
	private  UserService userService = new UserService();
	private  Scanner scan = new Scanner(System.in);
	
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
		System.out.println(user);
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
	

}
