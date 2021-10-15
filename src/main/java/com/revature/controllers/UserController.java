package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;



public class UserController {
	
	private  UserService userService = new UserService();
	private  Scanner scan = new Scanner(System.in);
	
	public void userMenu(User user){
//
//        String response="";
//        String monthString;
//        switch (response) {
//            case "1": 
////            case 2:  monthString = "February";
//                     break;
//            case 3:  monthString = "March";
//                     break;
//            case 4:  monthString = "April";
//                     break;
//            case 5:  monthString = "May";
//                     break;
//            case 6:  monthString = "June";
//                     break;
//            case 7:  monthString = "July";
//                     break;
//            case 8:  monthString = "August";
//                     break;
//            case 9:  monthString = "September";
//                     break;
//            case 10: monthString = "October";
//                     break;
//            case 11: monthString = "November";
//                     break;
//            case 12: monthString = "December";
//                     break;
//            default: monthString = "Invalid month";
//                     break;
     //   }
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
