
package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("hello");
		// 1.首先获得从request传来的数据，username和password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		JSONObject JsonObject = null;
		// 2.如果用户名为admin密码为1234则登录成功
		if (username.equals("admin") && password.equals("1234")) {
			JsonObject = new JSONObject("{flag:true}");
			// request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			// 给Ajax传递一个登录失败的信息
			JsonObject = new JSONObject("{flag:false}");

			// request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		response.getOutputStream().write(JsonObject.toString().getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
