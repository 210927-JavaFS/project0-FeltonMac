package com.revature.services;

import java.sql.Connection;

import com.revature.daos.BankAccountDao;
import com.revature.daos.BankAccountDaosImp;
import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.utilities.ConnectionUtil;

public class BankAccountServices {
	BankAccountDao accountdao = new BankAccountDaosImp();
	BankAccount account = new BankAccount();
	User user = new User();
	
	
	
	
	
}
