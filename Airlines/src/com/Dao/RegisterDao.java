package com.Dao;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisterDao {

	private String userName,email;
	private String userPhone,password;
	private String userAddress,role;
	
	public RegisterDao()
	{
		
	}
	
	
	
	//registering new admin

	public RegisterDao(String userName, String email, String userPhone, String password, String userAddress,
			String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.userPhone = userPhone;
		this.password = password;
		this.userAddress = userAddress;
		this.role = role;
	
	}
//registering new user

	public RegisterDao(String userName, String email, String userPhone, String password, String userAddress) {
		super();
		this.userName = userName;
		this.email = email;
		this.userPhone = userPhone;
		this.password = password;
		this.userAddress = userAddress;
	}

//getters and setters
	
	Scanner scan=new Scanner(System.in);

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}


	
	
	
	
	
	

	@Override
	public String toString() {
		return "RegisterDao [userName=" + userName + ", email=" + email + ", userPhone=" + userPhone + ", password="
				+ password + ", userAddress=" + userAddress + "]";
	}



	public void registerUser()
	{
		System.out.println("enter your name: ");
		userName=scan.next();
		System.out.println("Enter your email id: ");
		email=scan.next();
		System.out.println("enter phone number: ");
		 userPhone=scan.next();
		System.out.println("Enter your password: ");
		password=scan.next();
		System.out.println("enter your address: ");
		 userAddress=scan.next();
		RegisterDao reguser=new RegisterDao(userName,email,userPhone,password,userAddress);
		
		CreateConnect obj=new CreateConnect();
		obj.connect(); //for opening connection
		
		try {
			obj.registerNewUser(reguser); //for registering user in DB
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
