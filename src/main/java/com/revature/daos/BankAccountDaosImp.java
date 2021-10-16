package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.BankAccount;
import com.revature.utilities.ConnectionUtil;

public class BankAccountDaosImp implements BankAccountDao {

	@Override
	public List<BankAccount> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount getAccount() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAccountBalance(String accountnumberstring) {
		
		// TODO Auto-generated method stub
		return this.findAccount(accountnumberstring).getBalance();
	}

	@Override
	public BankAccount findAccount(String accountnumberstring) {
		
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM accounts_table WHERE account_number = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, accountnumberstring);
			
			ResultSet result = statement.executeQuery();
			
			BankAccount BAccount = new BankAccount();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			if(result.next()) {
				BAccount.setAccountnumber(result.getString("account_number"));
				BAccount.setBalance(result.getDouble("balance"));
			}
			return BAccount;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAcount() {
		// TODO Auto-generated method stub
		return false;
	}

}
