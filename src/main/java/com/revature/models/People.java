package com.revature.models;

import java.util.Objects;

public class People {
	private int id;
	private String firstname;
	private String lastname;
	public People() {
		// TODO Auto-generated constructor stub
	}
	public People(int id, String fname, String lname) {
		super();
		this.id = id;
		this.firstname = fname;
		this.lastname = lname;
	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstname, id, lastname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(firstname, other.firstname) && id == other.id && Objects.equals(lastname, other.lastname);
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	}
