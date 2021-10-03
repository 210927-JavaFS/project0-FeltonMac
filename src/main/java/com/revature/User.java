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
	// getters
	String getpassword(){
		return this.password;
	}
	String getusername() {
		return this.username;
	}
	int getid() {
		return this.id;
	}
	
	//setters
	void setpassword( String passchange){
		this.password = passchange;
	}
	void setusername(String userchange) {
		this.username= userchange;
	}
	void setid(int changeid) {
		this.id= changeid;
	}
	
}
