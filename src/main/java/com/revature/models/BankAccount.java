package com.revature.models;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(accountnumber, balance);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accountnumber, other.accountnumber)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance);
	}
	@Override
	public String toString() {
		return "BankAccount [accountnumber=" + accountnumber + ", balance=" + balance + "]";
	}
	

}