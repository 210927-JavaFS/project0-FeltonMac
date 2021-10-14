package com.revature.daos;

public interface TransactionDao {
	
	public void withdraw(String accountstring,Double withdrawamount);
	public void deposit(String accountstring,Double depositeamount);
	public void transfer(String addaccountstring,String subaccountstring,Double transferamount);
	public void showbalance(String accountstring);

}