package com.revature.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utilities.ConnectionUtil;

public class TransactionDaosImp implements TransactionDao {

	@Override
	public void withdraw(String accountstring, Double withdrawamount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE accounts_table SET balance = balance - ?"
					+"WHERE account_number = ?";
			
		PreparedStatement statement = conn.prepareStatement(sql);
		int count=0;	
			statement.setDouble(++count, withdrawamount);
			statement.setString(++count, accountstring );
			statement.execute();
			System.out.println(" statement executed");
			System.out.println(withdrawamount + ": withdrawn ");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("failed at Dao Method withdraw");
	}

	}

	@Override
	public void deposit(String accountstring, Double depositeamount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE accounts_table SET balance = balance + ?"
					+"WHERE account_number = ?";
			
		PreparedStatement statement = conn.prepareStatement(sql);
		int count=0;
			statement.setDouble(++count, depositeamount);
			statement.setString(++count, accountstring );
			statement.execute();
			System.out.println(" statement executed");
			System.out.println(depositeamount + ": deposite accepted ");
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println(" failed to deposit");
	}
		// TODO Auto-generated method stub
	}

	@Override
	public void transfer(String addaccountstring,String subaccountstring, Double transferamount) {
		deposit( addaccountstring,transferamount);
		withdraw(subaccountstring,transferamount);
			System.out.println("transaction complete");
	}
	
	
	@Override
	public void showbalance(String accountstring) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT balance FROM accounts_table \n"
			+ "WHERE account_number = ?";
			
			int count=0;
			
		PreparedStatement statement = conn.prepareStatement(sql);
		
			statement.setString(++count, accountstring);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
			System.out.println( result.getDouble(1));
			}
		}catch (SQLException e) {
		e.printStackTrace();
	}
		System.out.println(" balance displayed");

	}
	
	
	
	
	
	
	
	
}
