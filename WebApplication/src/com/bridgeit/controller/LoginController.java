package com.bridgeit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.LoginDao;
import com.bridgeit.model.LoginPojo;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Email = request.getParameter("email");
		String Password = request.getParameter("pass");
		
		LoginPojo log=new LoginPojo();
		log.setEmail(Email);
		log.setPassword(Password);

		try {
			if(LoginDao.validateUser(log))
			{
				
				System.out.println("Sucessfully login ");
			}
			else
			{
				System.out.println("authentication failed try again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
