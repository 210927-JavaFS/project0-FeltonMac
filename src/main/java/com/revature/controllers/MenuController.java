package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;

public class MenuController {

	static Scanner scan = new Scanner(System.in);
	User user = new User();
	static UserController userController = new UserController();
	static BankAccountController bankController = new BankAccountController();
	static UserService userService = new UserService();

	public void login(){

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
			System.out.println("       login failed");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("       create user?");
			String input = scan.nextLine();
			
			switch(input.toLowerCase()) {
			case "y":
			welcomeMenu(userController.newUserMenu());
			break;
			case "n":
			break;
			}
			login();
		}

	public void welcomeMenu(User user) {
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
