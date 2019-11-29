package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.DbConnection;


public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DbConnection dbConnection = new DbConnection();


	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		String result = dbConnection.login(user,pass);
		HttpSession session = request.getSession();		
		if(result!=null) {
			request.setAttribute("user", result);
			ServletContext context = getServletContext();
			RequestDispatcher dispatch = context.getRequestDispatcher("/Welcome.jsp");
			dispatch.forward(request, response);
//			PrintWriter out = response.getWriter();
//			response.setContentType("text/html");
//			out.println("Welocme : " + result );
		}
		else {
			  failLogin(response,session,request);
		}	
	}
	 
	 
	 public void failLogin(HttpServletResponse response,HttpSession session, HttpServletRequest request) throws IOException, ServletException {
		 request.getRequestDispatcher("index.html").include(request, response);
         if (session.getAttribute("loginCount") == null)
         {
             session.setAttribute("loginCount", 1);	               
         }
         else
         {
         int loginAttempt = (Integer) session.getAttribute("loginCount");        
              System.out.println(loginAttempt);
              if (loginAttempt > 3 ){
            	  request.setAttribute("error", "wrong user name and password");
     		    request.getRequestDispatcher("Register.html").forward(request, response);
     		}else{
     		     session.setAttribute("loginCount",++loginAttempt);
     		}
         }       
	 }
	
}
