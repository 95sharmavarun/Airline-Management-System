package com.User;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.LoginDao;
import com.Dao.RegisterDao;

public class Admin {
	Scanner scan=new Scanner(System.in);
	public void adminControl() throws SQLException
	{
		
		
		System.out.println("press 1 to add a new flight");
		System.out.println("press 2 to delete a flight");
		
		int choose=scan.nextInt();

		if(choose==1)
		{
			addFlights();
			
		}
		else if(choose==2)
		{
			deleteFlights();
			
		}
		else {
			System.out.println("choose valid options");
		}
		
		
	}
	
	public void addFlights() throws SQLException
	{
		//CreateConnect conn=new CreateConnect();
		Flight flightobj=new Flight();
		flightobj.newFlight();
		
	}
	
	
	public void deleteFlights() throws SQLException
	{
		System.out.println("enter flight id: ");
		int fid=scan.nextInt();
		Flight flightobj=new Flight();
		flightobj.deleteFlight(fid);
		
	}
	
	
}
