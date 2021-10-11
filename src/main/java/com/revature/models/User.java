package com.revature.models;

/**
 * @author Felton McCarty
 *
 */
public class User {
	//create basic fields
	String username, password;
	private int id;
	
	// constructor basic 
	User(){
		super();
	}
	public User(String username, String password, int id){
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	
	
}
