package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgeit.model.LoginPojo;

public class LoginDao {
	
	public static boolean validateUser(LoginPojo log) throws SQLException {
		
		boolean status=false;
		Connection con=JdbcConnection.establishConnection();
		PreparedStatement preparedStatement=null;
		
		String sql="select * from loginAuthentication where email=? and password=?";
		
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,log.getEmail());
		preparedStatement.setString(2,log.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();
		status=resultSet.next();
		
		return status;
	}
		
}

