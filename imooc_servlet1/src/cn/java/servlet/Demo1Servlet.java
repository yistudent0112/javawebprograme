package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ServletContext对象：表示的是整个JavaWeb工程
 * ServletConfig对象：表示的是某一个Servlet中的配置文件
 */
@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
         //获取某一个代表JavaWeb工程的ServletContext对象
		ServletContext context=this.getServletContext();
		//Context对象是一个域对象，可以往一个域对象中存放数据，并且还可以取出存放的数据
		//往context中存放一个值为"admin"的"username"
		context.setAttribute("username", "admin");
		//从context中取出username.
		Object username=context.getAttribute("username");
		//打印取出的结果
		System.out.println("username :"+username);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
