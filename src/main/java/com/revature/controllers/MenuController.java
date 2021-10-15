package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;

public class MenuController {

	 static Scanner scan = new Scanner(System.in);
	 User user = new User();
	 static UserController userController= new UserController();
	 static BankAccountController bankController = new BankAccountController();
	 static UserService userService = new UserService();
	 
		public void login() {
			
			System.out.println(" enter Username ");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			String loginUsername = inputString();

			System.out.println(" enter Password ");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			String loginPassword = scan.nextLine();

			User user = userService.login(loginUsername, loginPassword);
			if(user!=null) {
				welcomeMenu(user);
			}
			else {
				System.out.println("login failed");
				login();
			}
			
		}

	public void welcomeMenu(User user) {
		String response;
		do {
		System.out.println("     Bank information"      );
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
		
		
		//might have to put these in while loops
		switch (response){
		case "1":
			userController.userMenu(user);
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println(":     Select  Options      :");
			System.out.println("1) print all users         ");
			System.out.println("2) select user info        ");
			System.out.println("\n");
			System.out.println("0) EXIT");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			
			response = scan.nextLine();
			break;
			
		case "2":
			bankController.accountMenu(user);
			System.out.println();
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			
			System.out.println("     Select  Options      :");
			System.out.println("1) See account");
			System.out.println("2) Deposit");
			System.out.println("3) Withdraw");

			//see one
			System.out.println("4) EXIT");
			
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");			
			//scanner input=====================================
			
			response = scan.nextLine();
			break;
		
		}
			
		}
		while( !response.equals("0") );
	}

	
	
	public String inputString(){
		System.out.println("       Please Enter        ");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		String input =scan.nextLine();
		return input;
	}
	public int inputInt(){
		System.out.println("       Please Enter        ");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		int input =scan.nextInt();
		return input;
	}
	public Double inputDouble(){
		System.out.println("       Please Enter        ");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		Double input =scan.nextDouble();
		return input;
	
	}
	
}

