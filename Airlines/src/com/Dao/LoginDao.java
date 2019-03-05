package com.Dao;

import java.io.Console;
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
	int id;
 
 
 
 public LoginDao(int id,String email, String password,String role) {
	super();
	this.id=id;
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
	Console console = System.console();

	public void login() throws SQLException
	{
		List<LoginDao>retv=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email id: ");
		email=sc.next();
		//console.readPassword()
		//if(console != null){
		 //console.readPassword("Enter your password: ");
		//  password=sc.next();
		//}
		System.out.println("Enter your password: ");
		password=sc.next();
		
		
		CreateConnect conn=new CreateConnect();
		
		conn.connect();
		retv=conn.retrieve();
		//System.out.println("listing "+retv);
		//System.out.println("printing list ");
		int counter=0;
		for(LoginDao obj:retv)
		{
			
			//System.out.println("printing items "+obj);
			
			String em=obj.email;
			String pass=obj.password;
			role=obj.role;
			//System.out.println("em "+em+" "+pass+" "+email+" "+password);
			if(email.equals(em) && password.equals(pass))
			{
				
			if(role.equals("admin"))
			{
				//System.out.println("hi i am admin");
				Admin adminobj=new Admin();
				adminobj.adminControl(obj.email);
				counter++;
			}
			else {
				System.out.println("hi i am user");
				User userobj=new User();
				userobj.userControl(obj.email,obj.id);
				counter++;
			}
		}
			
			
		}
		
		if(counter==0)
		{
			System.out.println("invalid email id or password");
		}
		
	}
	
	
	
}
