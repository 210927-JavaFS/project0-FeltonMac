package com.revature.daos;

import java.util.List;

import com.revature.models.BankAccount;

public interface BankAccountDao {
//boolean createAccount();
//boolean deleteAccount();
	public List<BankAccount> findAll();
	public BankAccount findAccount(String accountnumberstring);
	public boolean addAcount();
	public BankAccount getAccount();
	public double getAccountBalance(String accountnumberstring);
	
}
