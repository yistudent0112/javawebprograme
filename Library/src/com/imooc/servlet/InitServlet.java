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
		// 创建一个UserList用于保存用户注册的信息:
		UserList userlist=new UserList();
		// 将Userlist保存到ServletContext作用域中:
        this.getServletContext().setAttribute("UserList", userlist);
        // 创建一个BookList用于保存书本的信息:
     	BookList booklist =new BookList();
        // 将Booklist保存到ServletContext作用域中:
        this.getServletContext().setAttribute("BookList", booklist);
        //创建一个BookCatgoryList用于保存分类书本信息；
        BookCatgoryList bookcatgorylist=new BookCatgoryList();
        //将bookcatgorylist保存到ServletContext作用域中去；
        this.getServletContext().setAttribute("BookCatgoryList", bookcatgorylist);
	}



}
