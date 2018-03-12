package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Helloservlet
 */
@WebServlet("/Helloservlet")
public class Helloservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("这是DoGet()方法");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.println("<strong>this is my first servlet.</strong><br>");
		ServletConfig temp=this.getServletConfig();
		Object username=temp.getInitParameter("username");
		out.print(username+"<br>");
		Object password=temp.getInitParameter("password");
		out.print(password);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("这是DoPost()方法");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.println("<strong>this is my first servlet.</strong><br>");
	
	}

}
