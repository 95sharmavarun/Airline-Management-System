package com.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Dao.CreateConnect;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String address;
	
	public User()
	{
		
	}
	
	
	public User(int id, String name, String email, String phone, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", address=" + address + "]";
	}
	
	
	Scanner scan=new Scanner(System.in);
	CreateConnect conn=new CreateConnect();
	
	public void userControl(String email,int id) throws SQLException
	{

		System.out.println("*************** WELCOME "+email+" ********************");
		
		
		int opt=1;
		do {
		
		
		System.out.println("-> press 1 to search flight");
		System.out.println("-> press 2 to book a flight");
		System.out.println("-> press 3 to cancel your booked flight");
		System.out.println("-> press 0 to exit");
		
		int choose=scan.nextInt();

		if(choose==1)
		{
			search();
			
		}
		else if(choose==2)
		{
			bookFlight(email,id);
			
		}
		
		else if(choose==3)
		{
			cancelFlight(email);
		}
		
		else if(choose==0)
		{
			break;
		}
		else {
			System.out.println("choose valid options");
		}
		
	}while(opt!=0);
	}
	
	
	
List<Flight>flightsearch=new ArrayList<>();
List<Flight>Cancelflightsearch=new ArrayList<>();
	public int search() throws SQLException
	{
		System.out.println("enter your source: ");
		String source=scan.next();
		System.out.println("enter your destination: ");
		String destination=scan.next();
		int c=0;
		
		conn.connect();
		flightsearch=conn.searchFlight(source,destination);
		
		if(flightsearch.size()>0) {
			c++;
			/*System.out.println("your flights are: ");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Flight id\t| Flight Name |"+" "+"\t| Source |"+"\t "+"| Destination |"+"\t"+"| Price |"+"\t "+"| Arrival Time |"+"\t "+"| Destination Time |"+"\t "+"| Seats Left |");
		for(Flight obj:flightsearch)
		{
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(obj);
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}*/
			
			
			
			
			
			
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%5s %20s %10s %14s %13s %16s %20s %14s ","Flight id","Flight Name","Source","Destination","Price","Arrival Time","Destination Time","Seats Left");
			System.out.println("");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
			for(Flight obj:flightsearch)
			{
				System.out.format("%5d %23s %10s %14s %14.2f %13s %16s %14d ",obj.fid,obj.fname,obj.source,obj.destination,obj.price,obj.arrivaltime,obj.destinationtime,obj.seatsleft);
				System.out.println("");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
			}
			
			
			
			
			
			
			
		}
		else {
			System.out.println("sorry there is no flight from your source to your destination...!!");
			c=0;
		}
		
		
		return c;
	}
	
	
	
	
	public void bookFlight(String email,int id) throws SQLException
	{
		double totalprice=0;
		int c=search();
		if(c==0)
		{
			userControl( email, id);
		}
	//	System.out.println("********** "+flightsearch.get(0).price);
		//flightsearch.get(0);
		else {
		int userid=id;
		
		System.out.println("enter number of seats you want to book: ");
		int seats=scan.nextInt();
		
		int totalseats=0;
		int count=0;
		System.out.println("enter flight id to be booked: ");
		int fid=scan.nextInt();
		
		for(int i=0;i<flightsearch.size();i++)
		{
			if(fid==flightsearch.get(i).fid)
			{
				count++;
				
				totalprice= seats * flightsearch.get(i).price;
				totalseats=flightsearch.get(i).seatsleft;
				totalseats-=seats;
				System.out.println("total price: "+totalprice+" totalseats: "+totalseats);
			}
		}
		
		if(count==0)
		{
			System.out.println("no flight available with "+fid+" id");
			userControl(email,userid);
		}
		
		else {
			conn.connect();
			conn.bookFlight(fid,id,totalprice,seats);
			conn.updateFlight(fid,totalseats);
			
			
		}
		
		}
		
		
		
		//double totalPrice=seats * flightsearch.get(4);
		
		
	}
	
	
	
	public void cancelFlight(String email) throws SQLException
	{
		/* System.out.println("-> press 1 to cance");*/
		int t=0,seats=0;
		int totalseats=0;
		int fid=0;
		do {
		System.out.println("Do you really want to cancel your booking ?");
		System.out.println("-> press 1 to proceed ");
		System.out.println("-> press 0 to exit");
		int opt=scan.nextInt();
		int count=0;
		if(opt==1)
		{
			conn.connect();
			seats=conn.fetch(email);
			System.out.println("booked seats are: "+seats);
			Cancelflightsearch=conn.showAllFlights();
//			id=conn.idfetch();
			//conn.updateFlight(fid,totalseats);
			
			if(seats>0) {
				
				System.out.println("enter your flight name: ");
					String flightName=scan.next();
				
				for(int i=0;i<Cancelflightsearch.size();i++)
				{
					if(Cancelflightsearch.get(i).fname.equals(flightName))
					{
						
						totalseats=Cancelflightsearch.get(i).seatsleft;
						fid=Cancelflightsearch.get(i).fid;
						totalseats+=seats;
						count++;
					}
				}
				if(count==0)
				{
					System.out.println("No such flight with Flight Name "+flightName);
				}
				else {

					conn.updateFlight(fid,totalseats);
					conn.cancellation(email);	
				}
				
				
				
				
			}
			else {
				System.out.println("no seats in booking");
			}
			
		}
		else if(opt==0)
		{
			t=1;
		}
		else {
			System.out.println("please choose valid option ");
		}
		
		
		}while(t!=0);
	}
	
	
	
	
		
		

}
