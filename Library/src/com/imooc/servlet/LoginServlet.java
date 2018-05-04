package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.utils.UserList;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if (UserList.UserMatch(user)) {
			response.sendRedirect(request.getContextPath() + "/server.jsp");
			request.getSession().setAttribute("LoginUser", username);
		} else {
			System.out.println("wrong");
			response.sendRedirect(request.getContextPath() + "/index.jsp?wrong=1");
		}
	}

}
