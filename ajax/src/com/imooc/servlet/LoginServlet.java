
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
		// 1.���Ȼ�ô�request���������ݣ�username��password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		JSONObject JsonObject = null;
		// 2.����û���Ϊadmin����Ϊ1234���¼�ɹ�
		if (username.equals("admin") && password.equals("1234")) {
			JsonObject = new JSONObject("{flag:true}");
			// request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			// ��Ajax����һ����¼ʧ�ܵ���Ϣ
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
