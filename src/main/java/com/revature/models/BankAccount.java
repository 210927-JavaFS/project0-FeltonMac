package com.revature.models;

public class BankAccount {
	private String accountnumber;
	private double balance;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String accountnumber, double balance) {
		super();
		this.accountnumber = accountnumber;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accountnumber=" + accountnumber + ", balance=" + balance + "]";
	}
	

}