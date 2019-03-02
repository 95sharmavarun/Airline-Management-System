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
	
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/airlines","root","varun");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public List<LoginDao> retrieve() throws SQLException
	{
		
		 pstmt=conn.prepareStatement("select email,password,role from Login");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			retv.add(new LoginDao(rs.getString(1),rs.getString(2),rs.getString(3)));
		}
		return retv;
	}
	
	
	public void addNewFlight(Flight obj) throws SQLException
	{
		
		pstmt=conn.prepareStatement("insert into domesticflight(fname,source,destination,price,arrivaltime,destinationtime) values (?,?,?,?,?,?)");
		pstmt.setString(1,obj.getFname() );
		pstmt.setString(2, obj.getSource());
		pstmt.setString(3, obj.getDestination());
		pstmt.setDouble(4, obj.getPrice());
		pstmt.setString(5, obj.getArrivaltime());
		pstmt.setString(6, obj.getDestinationtime());
		
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			System.out.println("new flight added successfully");
		}
		else {
			System.out.println("new flight not added successfully");
		}
		
	
		
	}
	
public void deleteFlight(int flightid) throws SQLException
{
	System.out.println("trying to delete "+flightid);
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
	
	
//	public static void main(String...strings ) throws SQLException
//	{
//		CreateConnect obj=new CreateConnect();
//		obj.connect();
//		obj.display();
//	}
//	
	
	
}
