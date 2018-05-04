package cn.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		// 用户名只能为字母，长度为6~12位
		String usernameRegex = "[a-zA-Z]{6,12}";
		// 密码只能为数字，长度要超过6位
		String passwordRegex = "[0-9]{6,}";
		// 手机号只能为数字，长度为11位
		String phoneRegex = "1[3578][0-9]{9}";
		// 邮箱为邮箱标准
		// matches函数的作用是判断是否满足正则表达式的要求，返回true或false
		boolean flag1 = username.matches(usernameRegex);
		boolean flag2 = password.matches(passwordRegex);
		boolean flag3 = phone.matches(phoneRegex);
		if (!(flag1 && flag2 && flag3)) {
			System.out.println("亲，你提交的数据没满足格式。");
		} else {
			System.out.println("username " + username);
			System.out.println("password " + password);
			System.out.println("phone " + phone);
			System.out.println("email " + email);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
