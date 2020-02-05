package org.btm.ChainApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
public class SecondServlet  extends HttpServlet
{
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//fetch request object back from scope
	String pname=(String) req.getAttribute("prdnm");
	String pqty=(String) req.getAttribute("prdqt");
	int qty=Integer.parseInt(pqty);
	double price=40000.00;
	double totalsum=(price*qty);//BUSINESS LOGIC
	req.setAttribute("tsum", totalsum);
	
	//PERSISTANCE LOGIC
	Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into btm.product values(?,?,?)";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
		pstmt=con.prepareStatement(qry);
		//set the value for PlaceHolder //
		pstmt.setString(1,pname);
		pstmt.setInt(2, qty);
		pstmt.setDouble(3, totalsum);
		
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
