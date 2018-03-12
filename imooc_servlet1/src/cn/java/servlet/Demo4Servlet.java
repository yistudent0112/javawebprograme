package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Demo4Servlet")
public class Demo4Servlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//ServletConfig对象	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//首先获得ServletConfig对象
		ServletConfig config=this.getServletConfig();
		Object encoding=config.getInitParameter("encoding");
		System.out.println(encoding);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
