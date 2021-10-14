package com.revature.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;

public class BankAccountController {
	
	private  BankAccountService accountService = new BankAccountService();
	private  Scanner scan = new Scanner(System.in);
	
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
	
	
	public boolean addAccount()throws InputMismatchException, Exception {////////////// you have not made add account in  bank dao will return null
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
	public void withdraw(String accountstring,Double withdrawamount)throws InputMismatchException, Exception {
		System.out.println("*---------------------*");
		System.out.println("insert the account number");
		String accountstring = scan.nextLine();
		System.out.println("*---------------------*");
		System.out.println("insert withdraw amount");
		double withdrawamount = scan.nextDouble();
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
