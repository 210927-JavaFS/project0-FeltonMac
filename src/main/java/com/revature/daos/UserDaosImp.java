package com.revature.daos;

import java.sql.Connection;
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
				String sql = "SELECT * FROM users;";                                                              // fin this specific query """""	String sql = "SELECT * FROM avengers;";"""
				
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
	public User findUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
