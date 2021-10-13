package com.revature.models;

/**
 * @author Felton McCarty
 *
 */
public class User {
	//create basic fields
	String username;
	String password;
	int id;
	String accesslevel;
	People person;
	BankAccount account;
	
	// constructor basic 
	public User(){
		super();
	}
	public User(String username, String password, int id){
		this.password= password;
		this.username= username;
		this.id= id;
		
	}
	
	
	
	public User(String username, String password, int id, String accesslevel, People person, BankAccount account) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.accesslevel = accesslevel;
		this.person = person;
		this.account = account;
	}
	// getters
	public String getPassword(){
		return this.password;
	}
	public String getUsername() {
		return this.username;
	}
	int getId() {
		return this.id;
	}
	public String getAccesslevel() {
		return accesslevel;
	}
	
	public People getPerson() {
		return person;
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setPerson(People person) {
		this.person = person;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
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
	public void setAccesslevel(String accesslevel) {
		this.accesslevel = accesslevel;
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
