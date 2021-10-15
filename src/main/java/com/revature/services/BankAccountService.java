package com.revature.services;

import java.sql.Connection;
import java.util.List;

import com.revature.daos.BankAccountDao;
import com.revature.daos.BankAccountDaosImp;
import com.revature.daos.TransactionDao;
import com.revature.daos.TransactionDaosImp;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaosImp;
import com.revature.models.BankAccount;
import com.revature.models.User;


public class BankAccountService {
	BankAccountDao accountdao = new BankAccountDaosImp();
	TransactionDao transactiondao = new TransactionDaosImp();
	UserDao userDao = new UserDaosImp();
	User user = new User();
	BankAccount account = new BankAccount();

	public List<BankAccount> findAllAccounts(){
		return accountdao.findAll();
	}
	
	public  BankAccount findAccount(String accountnumberstring){
		return accountdao.findAccount(accountnumberstring);
	}

	
	public boolean addAccount(BankAccount account) {
	 return accountdao.addAcount();
	}
	 
	public void withdraw(String accountstring,Double withdrawamount) {
		 transactiondao.withdraw(accountstring, withdrawamount);
	}
	public void deposit(String accountstring,Double depositeamount) {
		transactiondao.deposit(accountstring, depositeamount);
	}
	public void transfer(String addaccountstring,String subaccountstring,Double transferamount) {
		transactiondao.transfer(addaccountstring, subaccountstring, transferamount);
	}
	public void showbalance(String accountstring) {
		transactiondao.showbalance(accountstring);
	}

	}

	
	
