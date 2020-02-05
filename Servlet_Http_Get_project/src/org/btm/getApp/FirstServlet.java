package org.btm.getApp;

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
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
{
	String sid=req.getParameter("i");
	int id=Integer.parseInt(sid);
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String qry1="select * from btm.student where id=?";
     try
     {
    	 Class.forName("com.mysql.jdbc.Driver");
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
    	 
	     pstmt=con.prepareStatement(qry1);
	     pstmt.setInt(1, id);
	     
	     rs=pstmt.executeQuery();
	     if(rs.next())
	     {
	    	 String name=rs.getString(2);
	    	 double per=rs.getDouble(4);
	    	 PrintWriter out=resp.getWriter();
	    		out.println("<html><body bgcolor='green'>"
	    				+ "<h1>Student Details are Name "+name+" "+" Percentage "+per+"</h1>"
	    						+ "</body></html>");//Presentation logic//
	    		out.flush();
	    		out.close();
	    	 
	     }
	     else
	     {
	    	 PrintWriter out=resp.getWriter();
	    		out.println("<html><body bgcolor='green'>"
	    				+ "<h1>No such data persent</h1>"
	    						+ "</body></html>");//Presentation logic//
	    		out.flush();
	    		out.close(); 
	     }
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
