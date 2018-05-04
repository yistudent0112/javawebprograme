package com.imooc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.utils.UserList;

public class RegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserList userlist = (UserList) this.getServletContext().getAttribute("UserList");
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		// 用户名只能为字母，长度为6~12位
		String UsernameRegex = "[a-zA-Z0-9_]{3,12}";
		// 密码只能为数字，长度要超过6位
		String PasswordRegex = "[0-9]{6,12}";
		// 手机号只能为数字，长度为11位
		String PhoneRegex = "1[3578][0-9]{9}";
		// matches函数的作用是判断是否满足正则表达式的要求，返回true或false
		boolean flag1 = Username.matches(UsernameRegex);
		boolean flag2 = Password.matches(PasswordRegex);
		boolean flag3 = Phone.matches(PhoneRegex);
		if (!(flag1 && flag2 && flag3)) {
			response.sendRedirect(request.getContextPath()+"/regist.jsp?flag=1");
		}else {
		request.getSession().setAttribute("Username", Username);
		Map<String, String> map = new HashMap<String, String>();
		map.put("Username", Username);
		map.put("Password", Password);
		map.put("Phone", Phone);
		map.put("Email", Email);
		if (!userlist.AddUser(map)) {
			System.out.println("add user process is wrong");
		}
		this.getServletContext().setAttribute("UserList", userlist);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		doGet(request, response);
		}
	}

}
/*
 * 完成了两个数据类，和相关的servlet的数据读入，servlet中的数据处理还没有完全写完
 */
