package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.daos.BankAccountDaosImp;
import com.revature.models.BankAccount;
import com.revature.models.People;
import com.revature.models.User;
import com.revature.utilities.ConnectionUtil;


public class UserDaosImp implements UserDao {
	BankAccountDao accountdao = new BankAccountDaosImp();
//--------------------------------------------------------------------
	@Override
	public List<User> findAll() {
		
			try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
				String sql = "SELECT * FROM users;";                                                // fin this specific query """""	String sql = "SELECT * FROM avengers;";"""
				
				Statement statement = conn.createStatement();
				
				ResultSet result = statement.executeQuery(sql);
				
				List<User> list = new ArrayList<>();
				
				                                                                                    //ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
				 // if i make account here it will make one for all
				// database each time it is called in method
				
				//with a while loop to iterate through all the data. 
				
				while(result.next()) { //(String username, String password, int id, String accesslevel, People person, BankAccount account)
					User user = new User(
							result.getString("user_name"), 
							result.getString("user_password"),
							result.getInt("user_id"),
							result.getString("access_level"),
							null,
							null
							//result.getObject(people_id)
					 
							);
					
					// add first object
					//people"
					String ANfromresults=result.getString("account_number");
					// add second object 
					if (user.getAccount()== null) {
				
						BankAccount account = accountdao.findAccount(ANfromresults);/// does this need to be the implimented dao
						user.setAccount(account);
					}
					
					list.add(user);
					
				}
				return list;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		// TODO Auto-generated method stub
	}

	@Override
	public User findUser(String u) {
			try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
				String sql = "SELECT * FROM users WHERE user_name = ?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setString(1, u);
				
				ResultSet result = statement.executeQuery();
				
				User user = new User();
				
				
				if(result.next()) {
					
					user.setUsername(result.getString("user_name"));
					user.setPassword(result.getString("user_password"));
					//id
					user.setAccesslevel(result.getString("access_level"));
					user.setPerson(null);
					//user.setAccount(result.getString(""));
					user.setAccount(null);	

					// people account skiped
					// still need people object
					// if (rs.next())
					String ANfromresults = result.getString("account_number");
					if (user.getAccount() == null) {
						BankAccount account = accountdao.findAccount(ANfromresults);/// does this need to be the
																					/// implimented dao
						user.setAccount(account);
					}
				}
			
				System.out.println("User returning");
				System.out.println(user.toString());
				return user;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	// DOES NOT ADD FIRST AND LAST
	@Override
	public boolean addUser(User newUser) { 
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "INSERT INTO users(user_name ,user_password, access_level, account_number, people_id) \r\n"
						+ "VALUES (?,?,?,?);";
				
				int count = 0;
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setString(++count, newUser.getUsername());
				statement.setString(++count, newUser.getPassword());
				statement.setString(++count, newUser.getAccesslevel());
				statement.setString(++count, newUser.getAccount().getAccountnumber());
				statement.execute();
				
				return true;

			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
	@Override   // would have to check if this user exists or send all the null values with it test
	public boolean changePassword(User u ,String newPass) {
		// TODO Auto-generated method stub		
		try(Connection conn = ConnectionUtil.getConnection()){
			
		String sql = "UPDATE users AS u set u.password = ? WHERE u.username = ?";
		
		int count = 0;
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(++count, newPass);
		statement.setString(++count, u.getUsername());
		
		statement.execute();
		
		System.out.println(" method ran to completion go check ");
		return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return false;
	}
	
	
}
		


