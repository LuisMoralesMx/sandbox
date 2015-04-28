package com.sandbox.beans;

import com.sandbox.utils.Constants;

public class UserBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	public UserBean() {
		
		firstName = Constants.EMPTY_STRING;
		lastName = Constants.EMPTY_STRING;
		email = Constants.EMPTY_STRING;
		username = Constants.EMPTY_STRING;
		password = Constants.EMPTY_STRING;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}