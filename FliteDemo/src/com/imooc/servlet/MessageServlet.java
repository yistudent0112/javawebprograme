package com.imooc.servlet;
import com.imooc.domains.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//�����ݷ�װ��message��ȥ
		System.out.println(title+"  "+content);
		Message message=new Message();
		message.setContent(content);
		message.setTitle(title);
		//��message���뵽ר�Ŵ�ŵ�������ȥ
		List<Message>Messages=(List<Message>)request.getSession().getAttribute("messages");
		//��Messages������ʱ������Messages���󣬲���������session��
		if(Messages==null) {
			Messages=new ArrayList<Message>();
			request.getSession().setAttribute("messages", Messages);	
		}
		//������ӵ�message���뵽������ȥ
		Messages.add(message);
		response.sendRedirect(request.getContextPath()+"/message.jsp?servletflag=1");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
