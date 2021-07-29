package com.db;

import java.sql.*;
import java.util.*;

public class DBDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service_JDBC";
        String userName = "root";
        String password = "root1999";
        Connection con;
        try {
        	//connection to driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("Driver loaded");
        	
        } catch (ClassNotFoundException e) {
        	throw new IllegalStateException("Cannot fint the driver in the claspath!",e);
        }
        listDrivers();
        
        try {
        	System.out.println("Connecting to database:"+jdbcURL);
        	System.out.println("add");
        	//connection to database
        	con = DriverManager.getConnection(jdbcURL, userName, password);
        	System.out.println("Connecting is successful!!!!!"+con);
        }	
        	catch(Exception e) {
        		e.printStackTrace();
        }
	}
	//list of drivers
	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("  "+driverClass.getClass().getName());
			
		}
	}

}