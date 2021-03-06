package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.BankAccountDao;
import com.revature.daos.BankAccountDaosImp;
import com.revature.daos.TransactionDao;
import com.revature.daos.TransactionDaosImp;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaosImp;
import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.utilities.ConnectionUtil;


public class BankAccountService {
	BankAccountDao accountdao = new BankAccountDaosImp();
	TransactionDao transactiondao = new TransactionDaosImp();
	UserDao userDao = new UserDaosImp();
	User user = new User();
	BankAccount account = new BankAccount();
	private static Logger log =  LoggerFactory.getLogger(BankAccountService.class);

	public void findAllAccounts(){/////////////this is not here 
			System.out.println("all accounts:");
			List<BankAccount> list = accountdao.findAll();
			for(BankAccount account:list) {
				System.out.println(account.toString());
			}
		}
	
	public  BankAccount findAccount(String accountnumberstring){
		BankAccount accountreturned = accountdao.findAccount(accountnumberstring);
		accountreturned.toString();
		return accountreturned;
	}

	
	public boolean addAccount(String newadd) {
		log.info("account made please check data base");
	 return accountdao.addAcount(newadd);
	}
	 

	public void showbalance(String accountstring) {
		transactiondao.showbalance(accountstring);
	}
//	public void withdraw(String accountstring,Double withdrawamount) {
//	 transactiondao.withdraw(accountstring, withdrawamount);
//}
//public void deposit(String accountstring,Double depositeamount) {
//	transactiondao.deposit(accountstring, depositeamount);
//}
//public void transfer(String addaccountstring,String subaccountstring,Double transferamount) {
//	transactiondao.transfer(addaccountstring, subaccountstring, transferamount);
//}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////changes
	
	public boolean withdrawpullin(String accountstring, Double withdrawamount) {
		System.out.println("Start method withdrawpull");///////////////////////////////////////
		BankAccount account = accountdao.findAccount(accountstring);
		if (withdrawamount >= account.getBalance()) {
			System.out.println("withdraw amount too large ");
			return false;
		}
		account.setBalance(account.getBalance() - withdrawamount);
		if (accountdao.setBalance(account.getAccountnumber(), account.getBalance())) {
			System.out.println("withdraw set");
			return true;
		}
		System.out.println("no withdraw made try again");
		return false;
	}
	public boolean depositpullin(String accountstring, Double depositeamount) {
			BankAccount account = accountdao.findAccount(accountstring);
			account.setBalance(account.getBalance()+depositeamount);
			if(accountdao.setBalance(account.getAccountnumber(),account.getBalance())){
				System.out.println("deposit complete");
				return true;
			}
			System.out.println(" no deposite completed");
			return false;
	}
	public boolean transerferpullin(String wnumber,String dnumber, Double amount) {
		log.warn("transfer input manually please check database");
		withdrawpullin(wnumber,amount);
		depositpullin(dnumber,amount);
		
		System.out.println("  transaction  completed");
		return false;
	}
	

}

	
	
