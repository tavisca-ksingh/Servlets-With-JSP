package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	
	public String login(String user ,String pass) {
		String results=null;
			   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/employee","root","root");
	
	            Statement stmt=con.createStatement();
	            ResultSet rs = stmt.executeQuery("Select username,email from empData where username = \'" + user  
	            + "\' and pass = \'" + pass + "\'");
	            if(rs.next())
	            	results = rs.getString(1) + " " + rs.getString(2);
	            System.out.println(results);
	            con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return results;  
		   }
	
	public String registration(String user ,String pass,String email,String phone) {
		String results=null;
			   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/employee","root","root");
	
				Statement stmt = con.createStatement();
		            stmt.execute(
		            		"insert into empdata (username,pass,email,phone)  values (\'" + user + "\' , \'"
		            		+ pass + "\' , \'" + email + "\' , \'" + phone +"\')");
		            
	            System.out.println("New User Added");
	            con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return results;  
		   }

}
