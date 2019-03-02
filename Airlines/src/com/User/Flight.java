package com.User;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.CreateConnect;

public class Flight {

	String fname,source,destination,arrivaltime,destinationtime;
	double price;

	Flight()
	{
		
	}
	
	
	public Flight(String fname, String source, String destination, double price, String arrivaltime,
			String destinationtime) {
		super();
		this.fname = fname;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.arrivaltime = arrivaltime;
		this.destinationtime = destinationtime;
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
		return "Flight [fname=" + fname + ", source=" + source + ", destination=" + destination + ", price=" + price
				+ ", arrivaltime=" + arrivaltime + ", destinationtime=" + destinationtime + "]";
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
		
		Flight obj=new Flight(fname,source,destination,price,arrivaltime,destinationtime);
		
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
