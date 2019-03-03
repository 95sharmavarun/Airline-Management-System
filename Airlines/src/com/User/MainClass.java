package com.User;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.CreateConnect;
import com.Dao.LoginDao;
import com.Dao.RegisterDao;



public class MainClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("********************************************************");
		System.out.println("\t \t WELCOME TO FLIGHTWAYS");
		System.out.println("********************************************************");
		
		
		int opt=1;
		do {
		System.out.println("-> press 1 to register ");
		System.out.println("-> press 2 to login ");
		System.out.println("-> press 0 to exit ");
		Scanner scan=new Scanner(System.in);
		
		int choose=scan.nextInt();
		
		if(choose==1)
		{
			RegisterDao reg=new RegisterDao();
			reg.registerUser();
		}
		else if(choose==2)
		{
			LoginDao log=new LoginDao();
			log.login();
		}
		else if(choose==0)
		{
			System.exit(0);
		}
		else {
			System.out.println("choose valid option");
		}
		
		}while(opt!=0);
		
		
		
		
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
