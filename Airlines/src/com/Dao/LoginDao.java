package com.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.User.Admin;
import com.User.User;

public class LoginDao {
String email;
 String password;
 String role;	
	
 
 
 
 public LoginDao(String email, String password,String role) {
	super();
	this.email = email;
	this.password = password;
	this.role=role;
}

 public LoginDao()
 {
	 
 }









	@Override
	public String toString() {
		return "LoginDao [email=" + email + ", password=" + password + "]";
	}


	public void login() throws SQLException
	{
		List<LoginDao>retv=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email id: ");
		email=sc.next();
		System.out.println("Enter your password: ");
		password=sc.next();
		
		
		CreateConnect conn=new CreateConnect();
		
		conn.connect();
		retv=conn.retrieve();
		System.out.println("listing "+retv);
		System.out.println("printing list ");
		
		for(LoginDao obj:retv)
		{
			
			System.out.println("printing items "+obj);
			
			String em=obj.email;
			String pass=obj.password;
			role=obj.role;
			System.out.println("em "+em+" "+pass+" "+email+" "+password);
			if(email.equals(em) || password.equals(pass))
			{
				
			if(role.equals("admin"))
			{
				System.out.println("hi i am admin");
				Admin adminobj=new Admin();
				adminobj.adminControl();
			}
			else {
				System.out.println("hi i am user");
				User userobj=new User();
				userobj.userControl();
			}
		}
			else {
				System.out.println("invalid email id or password");
			}
			
		}
		
	}
	
	
	
}
