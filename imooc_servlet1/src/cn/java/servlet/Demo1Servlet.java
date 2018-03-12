package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ServletContext���󣺱�ʾ��������JavaWeb����
 * ServletConfig���󣺱�ʾ����ĳһ��Servlet�е������ļ�
 */
@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
         //��ȡĳһ������JavaWeb���̵�ServletContext����
		ServletContext context=this.getServletContext();
		//Context������һ������󣬿�����һ��������д�����ݣ����һ�����ȡ����ŵ�����
		//��context�д��һ��ֵΪ"admin"��"username"
		context.setAttribute("username", "admin");
		//��context��ȡ��username.
		Object username=context.getAttribute("username");
		//��ӡȡ���Ľ��
		System.out.println("username :"+username);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
