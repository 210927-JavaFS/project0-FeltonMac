package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utilities.ConnectionUtil;


public class UserDaosImp implements UserDao {
//--------------------------------------------------------------------
// add other objects here with dao imp classes to added to objects in list 
	@Override
	public List<User> findAll() {
		
			try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
				String sql = "SELECT * FROM users;";                                                // fin this specific query """""	String sql = "SELECT * FROM avengers;";"""
				
				Statement statement = conn.createStatement();
				
				ResultSet result = statement.executeQuery(sql);
				
				List<User> list = new ArrayList<>();
				
				                                                                                    //ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
				                                                                                    //with a while loop to iterate through all the data. 
				
				while(result.next()) {
					User user = new User(
							result.getString("user_name"), 
							result.getString("user_password"),
							result.getInt("user_id")
							
							//result.getObject(),
                            //Double d = (Double) resultSet.getObject("column");
							//result.getInt("account_number")
							//result.getObject(people_id)
							// get people  both are objects 
							// get bank account both are objects 
							);

					//String Account = result.getString("account");// object if it is a reference
					
				// add objects

					//if(homeName!=null) {
					//	Home home = homeDao.findByName(homeName);
					//	avenger.setHome(home);
					//}
					
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
		User result = new User();
	return  result;
	}
	@Override
	public boolean addUser(User newUser) {
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "INSERT INTO users(user_name ,user_password, access_level) \r\n"
						+ "VALUES (?,?,?);";
				
				int count = 0;
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setString(++count, newUser.getUsername());
				statement.setString(++count, newUser.getPassword());
				statement.setString(++count, newUser.getAccesslevel());
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
			 

		String sql = "UPDATE users AS u set u.password = ? where u.username = ?";
		
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
		


