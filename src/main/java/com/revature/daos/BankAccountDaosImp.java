package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.BankAccount;
import com.revature.utilities.ConnectionUtil;

public class BankAccountDaosImp implements BankAccountDao {
	private static Logger log = LoggerFactory.getLogger(BankAccountDao.class);
	@Override
	public List<BankAccount> findAll() {
		return null;
	}

	@Override
	public BankAccount getAccount() {
		
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
	public boolean setBalance(String accountstring, double newamount ) {
		System.out.println("SetBalanceStart");
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = " UPDATE accounts_table SET balance = ?"
					+"WHERE account_number = ?";
			
		PreparedStatement statement = conn.prepareStatement(sql);
		int count=0;
			statement.setDouble(++count, newamount);
			statement.setString(++count, accountstring );
			statement.execute();
			System.out.println(" statement executed");
			System.out.println(newamount + ": set ");
			return true;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println(" failed to set ");
	}
		return false;// TODO Auto-generated method stub
	}
	@Override
	public boolean addAcount(String newadd) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql =" INSERT INTO accounts_table (account_number)"
					+ "VALUES (?);";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, newadd);
			state.execute();
			System.out.println("add successful");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(" failed to add");
		}
		return false;
	}

}
