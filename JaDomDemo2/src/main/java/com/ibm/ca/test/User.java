package com.ibm.ca.test;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2924666846251580500L;
	private String firstname;
	private String lastname;
	private String middlename;
	
	
	
	public User(String firstname, String lastname, String middlename) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
	}
	public synchronized final String getFirstname() {
		return firstname;
	}
	public synchronized final void setFirstname(String firstname) {
		this.firstname = firstname;
		System.out.println("Lstname set to "+ this.lastname);
	}
	public synchronized final String getLastname() {
		return lastname;
	}
	public synchronized final void setLastname(String lastname) {
		this.lastname = lastname;
		System.out.println("Lstname set to "+ this.lastname);
		 
	}
	public synchronized final String getMiddlename() {
		return middlename;
	}
	public synchronized final void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	
}
