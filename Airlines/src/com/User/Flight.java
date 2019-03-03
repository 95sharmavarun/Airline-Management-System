package com.User;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.CreateConnect;

public class Flight {

	String fname,source,destination,arrivaltime,destinationtime;
	double price;
	int fid,seatsleft;
	Flight()
	{
		
	}
	
	
	public Flight(int fid,String fname, String source, String destination, double price, String arrivaltime,
			String destinationtime,int seatsleft) {
		super();
		this.fname = fname;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.arrivaltime = arrivaltime;
		this.destinationtime = destinationtime;
		this.fid=fid;
		this.seatsleft=seatsleft;
	}

	
	
	
	public int getSeatsleft() {
		return seatsleft;
	}


	public void setSeatsleft(int seatsleft) {
		this.seatsleft = seatsleft;
	}


	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getDestinationtime() {
		return destinationtime;
	}

	public void setDestinationtime(String destinationtime) {
		this.destinationtime = destinationtime;
	}

	@Override
	public String toString() {
		return "\t "+fid+"\t "+fname +"\t \t   "+source+ "\t   " + destination + "\t \t " + price
				+ "\t \t \t" + arrivaltime + "\t \t   " + destinationtime + "\t \t   "+seatsleft ;
	}
	
	public void newFlight() throws SQLException
	{
		Scanner x=new Scanner(System.in);
		System.out.println("enter flight name ");
		fname=x.nextLine();
		System.out.println("enter source");
		source=x.nextLine();
		System.out.println("enter destination");
		destination=x.next();
		System.out.println("enter price ");
		price=x.nextDouble();
		System.out.println("enter arrival time ");
		arrivaltime=x.next();
		System.out.println("enter destination time");
		destinationtime=x.next();
		System.out.println("enter number of seats in a flight: ");
		seatsleft=x.nextInt();
		Flight obj=new Flight(fid,fname,source,destination,price,arrivaltime,destinationtime,seatsleft);
		
		CreateConnect conn=new CreateConnect();
		conn.connect();
		conn.addNewFlight(obj);
		
		
		
	}
	
	
	public void deleteFlight(int fid) throws SQLException
	{
		CreateConnect conn=new CreateConnect();
		conn.connect();
		conn.deleteFlight(fid);
		
	}
	
	
	
	
}
