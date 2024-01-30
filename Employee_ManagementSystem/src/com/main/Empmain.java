package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.impl.Empimplement;
import com.service.Empl;
public class Empmain 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Empl emp = new Empimplement();
		Scanner sc = new Scanner(System.in);
		
		boolean b=true;
		while (b)
		{
			System.out.println("<<<<<<<<<<Welocme To Employee Management System>>>>>>>>>>");
			
			System.out.println("Enter 1 to Add Employee ");
			System.out.println("Enter 2 to Update Details ");	
			System.out.println("Enter 3 to View Details ");
			
			System.out.println("...............................");
			System.out.println("Enter your choice : ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				emp.AddEmployee();
				break;
				
			case 2:
				emp.UpdateDetails();
				break;
				
			case 3:
				emp.viewDetails();
				break;
			}
		}
	}
}