package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.services.UserService;

public class MenuController {
private static Logger log = LoggerFactory.getLogger(MenuController.class);
	static Scanner scan = new Scanner(System.in);
	User user = new User();
	static UserController userController = new UserController();
	static BankAccountController bankController = new BankAccountController();
	static UserService userService = new UserService();

	public void login(){
		log.info("login attempt: " + user.getUsername());
		System.out.println("      Enter Username ");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		String loginUsername = scan.nextLine();

		System.out.println("      Enter Password ");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		String loginPassword = scan.nextLine();

		User user = userService.login(loginUsername, loginPassword);
		if (user != null) {
			welcomeMenu(user);
		}
			System.out.println("          login");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("       create user?");
			System.out.println(":Select \"y\" for yes");
			System.out.println(":Select \"n\" for no");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");

			String input = scan.nextLine();
			
			switch(input.toLowerCase()) {
			case "y":
			welcomeMenu(userController.newUserMenu());
			login();
			break;
			case "n":
				System.out.println("*-------------------------*");
				System.out.println("*-------------------------*");
				System.out.println("*-------------------------*");
				System.out.println("*------ending app---------*");
				break;
			}
		
		}

	public void welcomeMenu(User user) {
		log.info(user.getUsername()+" this user has logged in");
		String response;
		do {
			System.out.println("     Bank information");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");

			System.out.println("    Select  Options      :");
			System.out.println("1) See User Options");
			System.out.println("2) See Account Options.");
			System.out.println("0) EXIT");

			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");

			response = scan.nextLine();

			// might have to put these in while loops
			switch (response) {
			case "1":
				userController.userMenu(user);
				break;

			case "2":
				bankController.accountMenu(user);
				break;
			}
			System.out.println("Reselect or end with \"0\"");
			response=scan.nextLine();
		} while (!response.equals("0"));

	}

}
