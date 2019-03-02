package com.User;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.CreateConnect;
import com.Dao.LoginDao;
import com.Dao.RegisterDao;



public class MainClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("press 1 to register ");
		System.out.println("press 2 to login ");
		
		Scanner scan=new Scanner(System.in);
		
		int choose=scan.nextInt();
		
		if(choose==1)
		{
			RegisterDao reg=new RegisterDao();
			reg.register();
		}
		else if(choose==2)
		{
			LoginDao log=new LoginDao();
			log.login();
		}
		else {
			System.out.println("choose valid option");
		}
		
		
		
		
		
		
		CreateConnect obj=new CreateConnect();
		obj.connect();
		try {
			obj.retrieve();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
