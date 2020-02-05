package org.btm.SessionApp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SecondServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
{
	HttpSession hs=req.getSession(false);
	String name=(String) hs.getAttribute("nmg");
	
	PrintWriter out=resp.getWriter();
	out.println("<html><body bgcolor='Yellow'>"
			+ "<h1>Session object is"+name+" "+hs.getId()+"</h1>"
					+ "</body></html>");
	out.flush();
	out.close();
	
}
}
