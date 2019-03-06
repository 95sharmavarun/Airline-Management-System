package com.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Dao.CreateConnect;
import com.Dao.RegisterDao;

public class Admin {
	
	
	Scanner scan=new Scanner(System.in);
	CreateConnect obj=new CreateConnect();
	List<Flight>showAllFlights=new ArrayList<>();
	
	
	
	
	
	public void adminControl(String email) throws SQLException
	{
		
		System.out.println("*************** WELCOME "+email+" ********************");
		System.out.println("-> press 1 to add a new flight");
		System.out.println("-> press 2 to delete a flight");
		System.out.println("-> press 3 to view all flights");
		System.out.println("-> press 4 to view booked flights");
		System.out.println("-> press 5 to add new Admin");
		System.out.println("-> press 6 to delete Admin");
		
		int choose=scan.nextInt();

		if(choose==1)
		{
			addFlights();
			
		}
		else if(choose==2)
		{
			deleteFlights();
			
		}
		else if(choose==3)
		{
			viewAllFlights();
			
		}
		else if(choose==4)
		{
			bookedFlights();
		}
		else if(choose==5)
		{
			addAdmin();
		}
		else if(choose==6)
		{
			deleteAdmin();
		}
		else {
			System.out.println("choose valid options");
		}
		
		
	}
	
	
	
	
	public void addAdmin() throws SQLException
	{
		
		
		System.out.println("enter your name: ");
		String userName=scan.next();
		System.out.println("Enter your email id: ");
		String email=scan.next();
		System.out.println("enter phone number: ");
		 String userPhone=scan.next();
		System.out.println("Enter your password: ");
		String password=scan.next();
		System.out.println("enter your address: ");
		 String userAddress=scan.next();
		// String role="admin";
		 
		 RegisterDao regobject=new RegisterDao(userName,email,userPhone,password,userAddress,"admin");
		 obj.connect();
		 obj.addNewAdmin(regobject);
		System.out.println("***");
		
		
		
	}
	
	
	public void deleteAdmin() throws SQLException
	{
		System.out.println("enter Admin email: ");
		String adminEmailid=scan.next();
		obj.connect();
		obj.deleteAdmin(adminEmailid);
	}
	
	
	
	
	
	public void viewAllFlights() throws SQLException
	{
		obj.connect();
		showAllFlights=obj.showAllFlights();
		System.out.println("Showing All Flights");
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		System.out.format("%5s %20s %10s %14s %13s %16s %20s %14s ","Flight id","Flight Name","Source","Destination","Price","Arrival Time","Destination Time","Seats Left");
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		for(Flight obj:showAllFlights)
		{
			System.out.format("%5d %23s %10s %14s %14.2f %13s %16s %14d ",obj.fid,obj.fname,obj.source,obj.destination,obj.price,obj.arrivaltime,obj.destinationtime,obj.seatsleft);
			System.out.println("");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
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
		
		obj.connect();
		obj.viewBookedFlights();
	}
	
	
}
