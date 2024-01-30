package com.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configure
{
	public Connection con=null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","root");
		return con;
	}
}