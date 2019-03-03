package com.Dao;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisterDao {

	private String email;
	private String password;
	private String role;
	
	public RegisterDao()
	{
		
	}
	
	
	
	//registering new admin
	public RegisterDao(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

//registering new user
	public RegisterDao(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	
	Scanner scan=new Scanner(System.in);

	public void registerUser()
	{
		System.out.println("Enter your email id: ");
		String userEmail=scan.next();
		System.out.println("Enter your password: ");
		String userPassword=scan.next();
		
		RegisterDao reguser=new RegisterDao(userEmail,userPassword);
		
		CreateConnect obj=new CreateConnect();
		obj.connect();
		
		try {
			obj.registerNewUser(reguser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
