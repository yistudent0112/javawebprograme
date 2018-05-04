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
		//把数据封装的message中去
		System.out.println(title+"  "+content);
		Message message=new Message();
		message.setContent(content);
		message.setTitle(title);
		//将message放入到专门存放的数组中去
		List<Message>Messages=(List<Message>)request.getSession().getAttribute("messages");
		//当Messages不存在时，创建Messages对象，并把它存入session中
		if(Messages==null) {
			Messages=new ArrayList<Message>();
			request.getSession().setAttribute("messages", Messages);	
		}
		//将新添加的message加入到数组中去
		Messages.add(message);
		response.sendRedirect(request.getContextPath()+"/message.jsp?servletflag=1");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
