package com.revature.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;

public class BankAccountController {
	BankAccount account;
	private  BankAccountService accountService = new BankAccountService();
	private  Scanner scan = new Scanner(System.in);
	
	public void accountMenu(User user) {
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("*-------------------------*");
		System.out.println("       Account menu ");
		System.out.println(" 1) find all Accounts ");
		System.out.println(" 2) find one Account ");
		System.out.println(" 3) add Account ");
		System.out.println(" 4) Deposite ");
		System.out.println(" 5) Witdraw ");
		System.out.println(" 6) Transfer");
		System.out.println(" 7) find all Accounts ");
		System.out.println(" 0)---------exit ---------- ");
		// switch statement
		String response = scan.nextLine(); 
		switch (response) {
		case "1":
			findAllAccounts();
			break;
		case "2":
			if(user.getAccount()!=null){
				displayOneaccount(user.getAccount().getAccountnumber());
			System.out.println();}
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			System.out.println(" 5) Witdraw ");
			double input =scan.nextDouble();
			withdraw(user.getAccount().getAccountnumber(),input);
			break;
		case "6":
			break;
		case "7":
			break;
		
		default : System.out.println("account menu end");
				break;
		
		}




		
		
	}
	
	public void findAllAccounts(){/////////////this is not here 
		System.out.println("all accounts:");
		List<BankAccount> list = accountService.findAllAccounts();
		for(BankAccount account:list) {
			System.out.println(account);
		}
	}

	public BankAccount displayOneaccount(String accountnumberstring) {
		System.out.println(" Account - number "+accountnumberstring+":");
		BankAccount account = accountService.findAccount(accountnumberstring);
		System.out.println(account);
		return account;
	}
	
	
	public boolean addAccount() {////////////// you have not made add account in  bank dao will return null
		System.out.println("*---------------------*");
		System.out.println("What is the account number?");
		String accountnumber = scan.nextLine();
		System.out.println("*---------------------*");
		System.out.println(" intial balance is ?");
		double balance = scan.nextDouble();
		System.out.println("*---------------------*");
		BankAccount account = new BankAccount(accountnumber, balance);
		
		if(accountService.addAccount(account)){
			System.out.println("successfully created");
			return true;
		}else {
			System.out.println("Something went wrong. Please try again.");
			return false;

		}
	}	
	public void withdraw(String accountstring,Double withdrawamount) {
		System.out.println("*---------------------*");
		System.out.println("account number entered: " + accountstring);
		System.out.println("*---------------------*");
		System.out.println("insert withdraw amount");
		
		while ((withdrawamount>500)||(withdrawamount<0)) {
			System.out.println("lower amount");
			 withdrawamount = scan.nextDouble();
		}
		 accountService.withdraw(accountstring, withdrawamount);
	}
	public void deposit(String accountstring,Double depositeamount) {
		accountService.deposit(accountstring, depositeamount);
	}
	public void transfer(String addaccountstring,String subaccountstring,Double transferamount) {
		accountService.transfer(addaccountstring, subaccountstring, transferamount);
	}
	public void showbalance(String accountstring) {
		accountService.showbalance(accountstring);
	}

	
	
}
