package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.demo.Employee;
import com.service.Empl;

public class Empimplement implements Empl 
{
	Scanner sc= new Scanner(System.in);
	Employee emp = new Employee();
	
	@Override
	public void AddEmployee() throws ClassNotFoundException, SQLException 
	{
		System.out.println("Enter Employee ID");
		int Id = sc.nextInt();
		
		System.out.println("Enter Employee Name");
		String Name = sc.next();
		
		System.out.println("Enter Employee Address");
		String Add = sc.next();
		
		System.out.println("Enter Employee Mobile No");
		long Mob = sc.nextLong();
		
		System.out.println("Enter Employee AAdhar No");
		long Aadar = sc.nextLong();
		
		System.out.println("Enter Gender");
		String Gender = sc.next();
		
		Connection con=Configure.getConnection();
		String sql="insert into Employee values("+Id+",'"+Name+"','"+Add+"',"
				     + ""+Mob+","+Aadar+",'"+Gender+"')";
		
		Statement smt=con.createStatement();
		smt.execute(sql);
		con.close();
		smt.close();
		
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("Employee Added Successfully......");
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println();
		
	}

	@Override
	public void UpdateDetails() throws ClassNotFoundException, SQLException {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter Employee ID whose details you want to update:");
	    int idToUpdate = sc.nextInt();
	    
	    Connection con = Configure.getConnection();
	    
	    System.out.println("Enter updated Employee Name:");
	    String updatedName = sc.next();

	    System.out.println("Enter updated Employee Address:");
	    String updatedAddress = sc.next();
	    
	    
	    String sql = "update Employee set Name = ?, Address = ? where ID = ?";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(sql))
	    {
	        pstmt.setString(1, updatedName);
	        pstmt.setString(2, updatedAddress);
	        pstmt.setInt(3, idToUpdate);

	        int rowsAffected = pstmt.executeUpdate();

	        if (rowsAffected > 0) 
	        {
	            System.out.println("Employee details updated successfully.");
	        } 
	        else 
	        {
	            System.out.println("No employee found with the given ID.");
	        }
	    } 
	    finally 
	    {
	       	        con.close();
	    }
	}


	@Override
	public void viewDetails() throws ClassNotFoundException, SQLException {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Enter Employee ID whose details you want to view:");
	    int idToView = sc.nextInt();

	    Connection con = Configure.getConnection();

	    String sql = "select * from Employee where ID = ?";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, idToView);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            String name = rs.getString("Name");
	            String address = rs.getString("Address");
	            long mobile = rs.getLong("MobileNo");
	            long aadhar = rs.getLong("AadharNo");
	            String gender = rs.getString("Gender");

	            System.out.println("Employee ID: " + id);
	            System.out.println("Employee Name: " + name);
	            System.out.println("Employee Address: " + address);
	            System.out.println("Employee Mobile No: " + mobile);
	            System.out.println("Employee Aadhar No: " + aadhar);
	            System.out.println("Employee Gender: " + gender);
	        } 
	        else 
	        {
	            System.out.println("No employee found with the given ID.");
	        }
	    } 
	    finally 
	    {
	        con.close();
	    }
	}


}