package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.User.Flight;

public class CreateConnect {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ArrayList<LoginDao>retv=new ArrayList<>();
	ArrayList<Flight>flightsearch=new ArrayList<>();
	ArrayList<Flight>CancelFlightsearch=new ArrayList<>();
	ArrayList<Flight>allFlightSearch=new ArrayList<>();
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/airlines","root","varun");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	public void registerNewUser(RegisterDao newUser) throws SQLException
	{
		pstmt=conn.prepareStatement("insert into login(name,email,phone,password,address) values (?,?,?,?,?)");
		pstmt.setString(1,newUser.getUserName());
		pstmt.setString(2, newUser.getEmail());
		pstmt.setString(3,newUser.getUserPhone());
		pstmt.setString(4, newUser.getPassword());
		pstmt.setString(5, newUser.getUserAddress());
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("new User added successfully");
		}
		else {
			System.out.println("new User not added successfully");
		}
	}
	
	
	
	public void addNewAdmin(RegisterDao newAdmin) throws SQLException
	{
		pstmt=conn.prepareStatement("insert into login(name,email,phone,role,password,address) values (?,?,?,?,?,?)");
		pstmt.setString(1,newAdmin.getUserName());
		pstmt.setString(2, newAdmin.getEmail());
		pstmt.setString(3,newAdmin.getUserPhone());
		pstmt.setString(4, newAdmin.getRole());
		pstmt.setString(5, newAdmin.getPassword());
		pstmt.setString(6, newAdmin.getUserAddress());
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("new Admin added successfully");
		}
		else {
			System.out.println("new Admin not added successfully");
		}
	}
	
	
	
	public void deleteAdmin(String AdminEmailid) throws SQLException
	{
		pstmt=conn.prepareStatement("delete from login where email= ?");
		pstmt.setString(1, AdminEmailid);
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("new Admin deleted successfully");
		}
		else {
			System.out.println("new Admin not deleted successfully");
		}
	}
	
	
	
	
	
	public List<LoginDao> retrieve() throws SQLException
	{
		
		 pstmt=conn.prepareStatement("select id,email,password,role from Login");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			retv.add(new LoginDao(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return retv;
	}
	
	
	public void addNewFlight(Flight obj) throws SQLException
	{
		
		pstmt=conn.prepareStatement("insert into domesticflight(fname,source,destination,price,arrivaltime,destinationtime,seatsleft) values (?,?,?,?,?,?,?)");
		pstmt.setString(1,obj.getFname() );
		pstmt.setString(2, obj.getSource());
		pstmt.setString(3, obj.getDestination());
		pstmt.setDouble(4, obj.getPrice());
		pstmt.setString(5, obj.getArrivaltime());
		pstmt.setString(6, obj.getDestinationtime());
		pstmt.setInt(7, obj.getSeatsleft());
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("new flight added successfully");
		}
		else {
			System.out.println("new flight not added successfully");
		}
		
	
		
	}
	
	
	
	
	
	public List<Flight> viewAllFlights() throws SQLException
	{
		

		allFlightSearch.clear();
		 pstmt=conn.prepareStatement("select fid,fname,source,destination,price,arrivaltime,destinationtime,seatsleft from domesticflight");
		 rs=pstmt.executeQuery();
			while(rs.next())
			{
				
				allFlightSearch.add(new Flight(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
			}
			return allFlightSearch;
		
		
	}
	
	
	
	
	
	
	
	
public void deleteFlight(int flightid) throws SQLException
{
	//System.out.println("trying to delete "+flightid);
	pstmt=conn.prepareStatement("delete from domesticflight where fid= ?");
	pstmt.setInt(1, flightid);
	
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		System.out.println("new flight deleted successfully");
	}
	else {
		System.out.println("new flight not deleted successfully");
	}
	
}



public List<Flight> searchFlight(String source,String destination) throws SQLException
{
	flightsearch.clear();
	System.out.println("searching...");
	 pstmt=conn.prepareStatement("select fid,fname,source,destination,price,arrivaltime,destinationtime,seatsleft from domesticflight where source=? and destination=?");
	 pstmt.setString(1, source);
	 pstmt.setString(2, destination);
	 rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			flightsearch.add(new Flight(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
		}
		return flightsearch;
	
}



public void bookFlight(int fid,int userid,double totalprice,int seats) throws SQLException
{
	pstmt=conn.prepareStatement("insert into booking(fid,id,totalprice,bookedseats) values (?,?,?,?)");
	pstmt.setInt(1,fid );
	pstmt.setInt(2, userid);
	pstmt.setDouble(3,totalprice);
	pstmt.setInt(4, seats);
	
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		System.out.println(" flight booking successfull");
	}
	else {
		System.out.println("flight booking not successfull...Please try again..!!");
	}
}

public void updateFlight(int flightid,int totalseats) throws SQLException
{
	pstmt=conn.prepareStatement("update domesticflight set seatsleft= ? where fid= ?");
	pstmt.setInt(1, totalseats);
	pstmt.setInt(2, flightid);
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		//System.out.println(" flight updated successfully");
	}
	else {
		System.out.println(" flight not updated successfully");
	}
}

public void viewBookedFlights() throws SQLException
{
	 pstmt=conn.prepareStatement("select * from booking ");
	
	 rs=pstmt.executeQuery();
	 System.out.println("-------------------------------------------------------------------------");
	 System.out.println("bookid"+" "+"Flight id"+" "+"user id"+" "+"total price"+" "+"booked seats");
	
	 while(rs.next())
		{
		 	System.out.println("------------------------------------------------------------------");
			System.out.println("  "+rs.getInt(1)+"\t "+rs.getInt(2)+"\t  "+rs.getInt(3)+"\t "+rs.getDouble(4)+"\t "+rs.getInt(5));
			System.out.println("------------------------------------------------------------------");
		}
	
}


public void cancellation(String email) throws SQLException
{
	pstmt=conn.prepareStatement("delete from booking where id=(select id from login where email=?)");
	pstmt.setString(1, email);
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		System.out.println(" booking cancelled successfully");
	}
	else {
		System.out.println(" booking not cancelled successfully");
	}
	
}

public int fetch(String email) throws SQLException
{
	pstmt=conn.prepareStatement("select bookedseats from booking where id=(select id from login where email=?)");
	pstmt.setString(1, email);
	rs=pstmt.executeQuery();
	int seats=0;
	while(rs.next())
	{
		seats=rs.getInt(1);
	}
	
	return seats;
}


public List<Flight> showAllFlights() throws SQLException
{
	CancelFlightsearch.clear();
	 pstmt=conn.prepareStatement("select fid,fname,source,destination,price,arrivaltime,destinationtime,seatsleft from domesticflight");
	 rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			CancelFlightsearch.add(new Flight(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
		}
		return CancelFlightsearch;
	
}


	
//	public void idFetch() 
//	{ 
//		pstmt=conn.
//	 prepareStatement("select fid from domesticflight where fid=(select id from login where email=?)"); 
//		//pstmt.setString(1, email); 
//		rs=pstmt.executeQuery(); 
//		int seats=0;
//	 while(rs.next()) { seats=rs.getInt(1); }
//	 
//	 return seats; 
//	 }
//	 
//		
//	public static void main(String...strings ) throws SQLException
//	{
//		CreateConnect obj=new CreateConnect();
//		obj.connect();
//		obj.display();
//	}
//	
	
	
}
