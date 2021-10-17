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
	double input;
	String input2;
	String input1;
	User currentinfo= new User();
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
		System.out.println(" 7) Showbalance ");
		System.out.println(" 0)---------exit ---------- ");
		// switch statement
		String response = scan.nextLine(); 
		switch (response) {
		case "1":
			accountService.findAllAccounts();
			break;
		case "2":
			// null pointer... account never grabed account info from dao
			System.out.println(" printing the users account "+ user.getAccount());
			if(user.getAccount()!=null){
				System.out .println(" printing the users account "+ user.getAccount());
				displayOneaccount(user.getAccount().getAccountnumber());
			System.out.println();}
			break;
		case "3":
			System.out.println("3) add acount");
			if (user.getAccesslevel()=="two"||user.getAccesslevel()=="three") {
				System.out.println("what is the account number?");
				String madeaccount=scan.nextLine();
				accountService.addAccount(madeaccount);
			}else {
				System.out.println("you do not have access");
			}
			break;
		case "4":
			System.out.println(" 4) deposit ");
			System.out.println(" input deposit amount "); 
			while (!scan.hasNextDouble()) {
				System.out.println("Input a double amount Ex 0.00");
				scan.nextLine();
			}
			input = scan.nextDouble();
			accountService.depositpullin(user.getAccount().getAccountnumber(),input);
			//deposit(user.getAccount().getAccountnumber(), input);
			break;
		case "5":
			System.out.println(" 5) Witdraw ");
			System.out.println(" input withdraw amount ");
			while (!scan.hasNextDouble()) {
				System.out.println("Input a double amount Ex 0.00");
				scan.nextLine();
			}
			input = scan.nextDouble();
			System.out.println(user.toString());
			accountService.withdrawpullin(user.getAccount().getAccountnumber(), input);
			break;
		case "6":
			System.out.println(user.toString());
			if (user.getAccesslevel().equals( "two") || user.getAccesslevel().equals("three")) {
				System.out.println(" 6) Transfer ");
				System.out.println("user  account " + user.getAccount().getAccountnumber());
				System.out.println(" which account do you wish to remove funds from ");
				input1 = scan.nextLine();
				System.out.println(" which account do you wish to send to ");
				input2 = scan.nextLine();
				System.out.println(" input transfer amount ");
				input = scan.nextDouble();
				accountService.transerferpullin(input1, input2, input);
				// transfer(user.getAccount().getAccountnumber(),input2,input);
			}else System.out.println("sorry you dont have acces yet");
			break;
		case "7":
			accountService.showbalance(user.getAccount().getAccountnumber());
			break;
		
		default : System.out.println("account menu end");
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
				System.out.println(" 7) Showbalance ");
				System.out.println(" 0)---------exit ---------- ");
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
		System.out.println(" Account  number "+accountnumberstring+":");
		BankAccount account = accountService.findAccount(accountnumberstring);
		System.out.println(account);
		return account;
	}
	
	/*
	 * public boolean addAccount() {////////////// you have not made add account in
	 * bank dao will return null System.out.println("*---------------------*");
	 * System.out.println("What is the account number?"); String accountnumber =
	 * scan.nextLine(); System.out.println("*---------------------*");
	 * System.out.println(" intial balance is ?"); double balance =
	 * scan.nextDouble(); System.out.println("*---------------------*"); BankAccount
	 * account = new BankAccount(accountnumber, balance);
	 * 
	 * if(accountService.addAccount(account)){
	 * System.out.println("successfully created"); return true; }else {
	 * System.out.println("Something went wrong. Please try again."); return false;
	 * } } public
	 */ void withdraw(String accountstring,Double withdrawamount)throws java.lang.NullPointerException,InputMismatchException {
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
	public void deposit(String accountstring,Double depositeamount)throws java.lang.NullPointerException,InputMismatchException{
		System.out.println("*---------------------*");
		System.out.println("account number entered: " + depositeamount);
		System.out.println("*---------------------*");
		System.out.println("insert deposite amount");
		while ((depositeamount>500)||(depositeamount<0)) {
			System.out.println("lower amount");
			depositeamount = scan.nextDouble();
		}
		accountService.deposit(accountstring, depositeamount);
	}
	public void transfer(String addaccountstring,String subaccountstring,Double transferamount)throws java.lang.NullPointerException,InputMismatchException {
		System.out.println("*---------------------*");
		System.out.println("account number entered: " + subaccountstring);// you need to be able to choose or flip these
		System.out.println("account number entered: " + transferamount);
		System.out.println("*---------------------*");
		System.out.println("insert transfer amount amount");
		accountService.transfer(addaccountstring, subaccountstring, transferamount);
	}
	public void showBalance(String accountstring)throws java.lang.NullPointerException,InputMismatchException {
		accountService.showbalance(accountstring);
	}

	
	
}
