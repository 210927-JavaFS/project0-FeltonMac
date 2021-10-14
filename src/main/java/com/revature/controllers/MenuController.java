package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.UserService;

public class MenuController {

	 static Scanner scan = new Scanner(System.in);
	// static UserController  = new UserController();
	// static BankAccountController = new BankAccountController();
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
	
	
	public void welcomeMenu() {
		String response;
		do {
		System.out.println("     Bank information"      );
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		
		System.out.println("    Select  Options      :");
		System.out.println("1) See User Options");
		System.out.println("2) See Account Options.");
		System.out.println("3) EXIT");
		
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");

		response = scan.nextLine();
		
		
		//might have to put these in while loops
		switch (response){
		case "1":
			//UserController();
		
			System.out.println();
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			
			
			System.out.println("     Select  Options      :");
			System.out.println("1) See All");
			System.out.println("2) Add");
			//see one
			System.out.println("4) EXIT");
			
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			System.out.println("*-------------------------*");
			// scanner input============================================================================
			response = scan.nextLine();
			if(response.equals("1")) {
				//userdao all
			}
			if(response.equals("2")) {
				//userdao add
			}
			break;
		case "2":
			//Account controller
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
		
			default: continue;
		}
			
		}
		while( !response.equals("4") );
	}
	public void login() {
		String loginUsername = inputString();
;
		String loginPassword = inputString();
		
		// TODO Auto-generated method stub
		
	}
	
	public void userController(){
		
		System.out.println();
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		
		
		System.out.println("     Select  Options for user    :");
		System.out.println("1) See All");
		System.out.println("2) Add");
		//see one
		System.out.println("4) EXIT");
		
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		// scanner input============================================================================
		String response = scan.nextLine();
		public void getuserService(){
			return UserService.startService();
		}
	}
}

