package org.btm.ContextApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/bp")
public class BookServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException 
	{
		ServletContext ctx=getServletContext();
		String offermsg=ctx.getInitParameter("ofm");
		String offerper=ctx.getInitParameter("ofp");
		
		Product pd=(Product) ctx.getAttribute("prd");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='blue'>"
				+ "<h1>Book Product Details</h1><p>"
				+ " "+offermsg+" "+offerper+"%OFF"
				+"<br><a href=\"product.html\">Back</a>"
				+ "</body></html>");
		out.flush();
		out.close();
		
		
	}
	

}
