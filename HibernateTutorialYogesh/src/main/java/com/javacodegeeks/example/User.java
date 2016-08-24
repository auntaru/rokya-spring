package com.javacodegeeks.example;

public class User {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	
	public User() 
	{
		
	}
	
	public User(int userid, String firstname, String lastname, String email, String username)
	{
		this.setId(userid);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setUsername(username);				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	

}
