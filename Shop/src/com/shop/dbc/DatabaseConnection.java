package com.shop.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/shop";
	private static final String DBNAME = "user1";
	private static final String DBPASSWORD = "user1";
	private Connection conn = null;
	
	public DatabaseConnection() throws ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBNAME, DBPASSWORD);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	public void close() throws Exception
	{
		if (conn != null)
		{
			conn.close();
		}
	}
}
