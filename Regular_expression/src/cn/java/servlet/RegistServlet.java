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
		// �û���ֻ��Ϊ��ĸ������Ϊ6~12λ
		String usernameRegex = "[a-zA-Z]{6,12}";
		// ����ֻ��Ϊ���֣�����Ҫ����6λ
		String passwordRegex = "[0-9]{6,}";
		// �ֻ���ֻ��Ϊ���֣�����Ϊ11λ
		String phoneRegex = "1[3578][0-9]{9}";
		// ����Ϊ�����׼
		// matches�������������ж��Ƿ�����������ʽ��Ҫ�󣬷���true��false
		boolean flag1 = username.matches(usernameRegex);
		boolean flag2 = password.matches(passwordRegex);
		boolean flag3 = phone.matches(phoneRegex);
		if (!(flag1 && flag2 && flag3)) {
			System.out.println("�ף����ύ������û�����ʽ��");
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
