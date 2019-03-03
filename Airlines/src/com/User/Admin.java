package com.User;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.CreateConnect;

public class Admin {
	Scanner scan=new Scanner(System.in);
	public void adminControl(String email) throws SQLException
	{
		
		System.out.println("*************** WELCOME "+email+" ********************");
		System.out.println("-> press 1 to add a new flight");
		System.out.println("-> press 2 to delete a flight");
		System.out.println("-> press 3 to view all flights");
		System.out.println("-> press 4 to view booked flights");
		
		int choose=scan.nextInt();

		if(choose==1)
		{
			addFlights();
			
		}
		else if(choose==2)
		{
			deleteFlights();
			
		}
		else if(choose==4)
		{
			bookedFlights();
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
	
	
	public void bookedFlights() throws SQLException
	{
		CreateConnect obj=new CreateConnect();
		obj.connect();
		obj.viewBookedFlights();
	}
	
	
}
