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
	//创建一个list集合用来存贮user类型的数据
	List<User>list=new ArrayList<User>();
    //将list保存到ServletContext作用域中
	this.getServletContext().setAttribute("list", list);
}


}
