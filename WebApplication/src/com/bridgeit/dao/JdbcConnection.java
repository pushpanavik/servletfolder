package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnection {
	
	public static Connection establishConnection()
	{
		String url="jdbc:mysql://localhost:3306/demo";
		String username="pushpa";
		String password="pushpa1992";
		Connection connection=null;
	
	try {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,username ,password );
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	if(connection!=null)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return connection;
}	

}
