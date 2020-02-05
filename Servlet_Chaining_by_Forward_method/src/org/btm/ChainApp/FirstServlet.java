package org.btm.ChainApp;
import java.io.IOException;

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
		rd.forward(req, resp);
	}
}
