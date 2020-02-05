package org.btm.uiApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/btm")
public class FirstServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		String fname=req.getParameter("fn");
		String lname=req.getParameter("ln");
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='blue'>"
				+ " <h1> DABBA FELLO "+  fname +" "+lname+"</h1>"+"</body></html>");
		out.flush();
		out.close();
	}
	

}
