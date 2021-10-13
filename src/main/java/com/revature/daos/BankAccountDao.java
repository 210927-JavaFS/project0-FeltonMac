package com.revature.daos;

import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.User;

public interface BankAccountDao {
//boolean createAccount();
//boolean deleteAccount();
	public List<User> findAll();
	public BankAccount getAccount();
	public double getAccountBalance();

}
