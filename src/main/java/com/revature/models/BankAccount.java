package com.revature.models;

public class BankAccount {
	private String accountnumber;
	private double balance;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String id, double balance) {
		super();
		this.accountnumber = id;
		this.balance = balance;
	}
	public String getId() {
		return accountnumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setId(String id) {
		this.accountnumber = id;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [id=" + accountnumber + ", balance=" + balance + "]";
	}

}