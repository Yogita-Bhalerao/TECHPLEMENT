package com.service;

import java.sql.SQLException;

public interface Empl 
{
	public void AddEmployee() throws ClassNotFoundException, SQLException;
	public void UpdateDetails() throws ClassNotFoundException, SQLException;
	public void viewDetails() throws ClassNotFoundException, SQLException;
}