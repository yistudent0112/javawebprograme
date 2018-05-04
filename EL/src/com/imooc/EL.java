package com.imooc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EL extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	//1.首先获取name和password属性的值
		String name=request.getParameter("name");
		String password=request.getParameter("password");
	//2.将获取的数据保存到request域中去
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		System.out.println(name);
		System.out.println(password);
	//3.将页面跳转到show.jsp上去，并使用EL表达式来显示数据
		//response.sendRedirect("/EL/ELshow.jsp");
		request.getRequestDispatcher("/ELshow.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
