package org.btm.postApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet 
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
{
	String sid=req.getParameter("i");
	int id=Integer.parseInt(sid);
	String name=req.getParameter("nm");
	String dept=req.getParameter("dp");
	String sper=req.getParameter("pr");
	double per=Double.parseDouble(sper);
	
	PrintWriter out=resp.getWriter();
	out.println("<html><body bgcolor='green'>"
			+ "<h1>Student Details are Name "+name+" "+" Department "+dept+"</h1>"
					+ "</body></html>");//Presentation logic//
	out.flush();
	out.close();
	
	//persistance logic//
	Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into btm.student values(?,?,?,?)";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
		pstmt=con.prepareStatement(qry);
		//set the value for PlaceHolder //
		pstmt.setInt(1,id);
		pstmt.setString(2, name);
		pstmt.setString(3, dept);
		pstmt.setDouble(4, per);
		
		pstmt.executeUpdate();
		
	} catch (ClassNotFoundException | SQLException e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		if(pstmt!=null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
}
}
