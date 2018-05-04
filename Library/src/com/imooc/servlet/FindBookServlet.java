package com.imooc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.Book;
import com.imooc.utils.BookList;


public class FindBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String bookId=request.getParameter("bookID");
		String bookName=request.getParameter("bookName");
		String catgoryName=request.getParameter("catgoryName");
		//System.out.println(bookId);
		BookList booklist = (BookList) this.getServletContext().getAttribute("BookList");
		List<Book>list=new ArrayList<Book>();
		if(bookId!=null) {
			list.add(booklist.FindBook(bookId));
		}
		if(bookName!=null) {
			list.add(booklist.FindBookByName1(bookName));
		}
		System.out.println(list);
		request.setAttribute("list", list);
	
		response.sendRedirect(request.getContextPath()+"/showBooks.jsp");
		doGet(request, response);
	}

}
