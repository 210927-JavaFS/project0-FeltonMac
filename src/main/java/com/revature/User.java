/**
 * 
 */
package com.revature;

/**
 * @author Felton McCarty
 *
 */
public class User {
	//create basic fields
	String username, password;
	int id;
	
	// constructor basic 
	User(){
		
	}
	User(String username, String password, int id){
		
		this.password= password;
		this.username= username;
		this.id= id;
		
	}
	// get setters
	String getpassword(){
		return this.password;
	}
	String getusername() {
		return this.username;
	}
	int getid() {
		return this.id;
	}
	
}
