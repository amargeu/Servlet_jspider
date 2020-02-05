package org.btm.ChainApp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String pname=req.getParameter("pn");
		String pqty=req.getParameter("pq");
		//add request object into Scope
		req.setAttribute("prdnm",pname);
		req.setAttribute("prdqt", pqty);
		
		RequestDispatcher rd=req.getRequestDispatcher("ss");
		rd.include(req, resp);
		double totalsum=(double) req.getAttribute("tsum");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='green'>"
				+ "<h1>Product name is  "+pname+" "+" totalprice "+totalsum+"</h1>"
						+ "</body></html>");//Presentation logic//
		out.flush();
		out.close();
		
		
	}
}
