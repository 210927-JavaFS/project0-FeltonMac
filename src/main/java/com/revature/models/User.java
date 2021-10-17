package com.revature.models;

import java.util.Objects;

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
	public User(String username, String password, String acceslevel){
		this.password= password;
		this.username= username;
		this.accesslevel= acceslevel;
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
	public void setPassword( String passchange){
		this.password = passchange;
	}
	public void setUsername(String userchange) {
		this.username= userchange;
	}
	public void setId(int changeid) {
		this.id= changeid;
	}
	public void setAccesslevel(String accesslevel) {
		this.accesslevel = accesslevel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accesslevel, account, id, password, person, username);
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
		return Objects.equals(accesslevel, other.accesslevel) && Objects.equals(account, other.account)
				&& id == other.id && Objects.equals(password, other.password) && Objects.equals(person, other.person)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", accesslevel=" + accesslevel
				+ ", person=" + person + ", account=" + account + "]";
	}
	
	

	
	
}
