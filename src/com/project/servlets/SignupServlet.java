package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.DbConnection;


public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection dbConnection = new DbConnection();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		dbConnection.registration(user, pass, email, phone);
		
		
	}

}
