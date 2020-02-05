package org.btm.SessionApp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FirstServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
{
    String name=req.getParameter("nm");
	 HttpSession hs=req.getSession();
	 hs.setMaxInactiveInterval(-1);
	 hs.setAttribute("nmg",name);
	 
	 PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form action='ss'>");
		out.print("<input type='submit' value='NextServlet'>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.flush();
		out.close();
	 

}
}
