package com.imooc.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	//����һ��list������������user���͵�����
	List<User>list=new ArrayList<User>();
    //��list���浽ServletContext��������
	this.getServletContext().setAttribute("list", list);
}


}
