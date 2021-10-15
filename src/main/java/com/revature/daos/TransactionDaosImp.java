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
			String sql = "UPDATE accounts_table SET balance = balance - ? \n"
					+"Where accountnumber = ?";
			
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
			String sql = "UPDATE accounts_table SET balance = balance + ? \n"
					+"Where accountnumber = ?";
			
		PreparedStatement statement = conn.prepareStatement(sql);
		int count=0;	
			statement.setDouble(++count, depositeamount);
			statement.setString(++count, accountstring );
			statement.execute();
			System.out.println(" statement executed");
			System.out.println(depositeamount + ": deposite accepted ");
	} catch (SQLException e) {
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
	}

	@Override
	public void transfer(String addaccountstring,String subaccountstring, Double transferamount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE accounts_table SET balance = balance + ? \n"
					+"Where accountnumber = ?";
			
			String sql2="UPDATE accounts_table SET balance = balance - ? \n"
				+"Where accountnumber = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			int count=0;	
				statement.setDouble(++count, transferamount);
				statement.setString(++count, addaccountstring );
				statement.executeUpdate();
				
				
			PreparedStatement statement2 = conn.prepareStatement(sql2);
			int count2=0;	
					statement2.setDouble(++count2, transferamount);
					statement2.setString(++count2, subaccountstring );
					statement2.executeUpdate();
			
			System.out.println("transaction complete");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public void showbalance(String accountstring) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT balance FROM accounts_table \n"
			+ "WHERE accountnumber = ?";
			
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

		// TODO Auto-generated method stub

	}
}
