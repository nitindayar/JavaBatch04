package com.DBUtility;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public static java.sql.Connection connection()
	//public static void main(String args[])
	{
		java.sql.Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded successfully");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB3","root","root");
			System.out.println("connection done successfully");
		} 
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return con;
	}
}
