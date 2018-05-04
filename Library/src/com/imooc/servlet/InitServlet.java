package com.imooc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.utils.BookCatgoryList;
import com.imooc.utils.BookList;
import com.imooc.utils.UserList;


public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// ����һ��UserList���ڱ����û�ע�����Ϣ:
		UserList userlist=new UserList();
		// ��Userlist���浽ServletContext��������:
        this.getServletContext().setAttribute("UserList", userlist);
        // ����һ��BookList���ڱ����鱾����Ϣ:
     	BookList booklist =new BookList();
        // ��Booklist���浽ServletContext��������:
        this.getServletContext().setAttribute("BookList", booklist);
        //����һ��BookCatgoryList���ڱ�������鱾��Ϣ��
        BookCatgoryList bookcatgorylist=new BookCatgoryList();
        //��bookcatgorylist���浽ServletContext��������ȥ��
        this.getServletContext().setAttribute("BookCatgoryList", bookcatgorylist);
	}



}
