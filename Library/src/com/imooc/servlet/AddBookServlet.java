package com.imooc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.Book;
import com.imooc.utils.BookList;

public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		BookList booklist = (BookList) this.getServletContext().getAttribute("BookList");
		
			String Id = request.getParameter("id");
			String BookName = request.getParameter("bookName");
			String CatgoryName = request.getParameter("catgoryName");
			String Price = request.getParameter("price");
			String Description = request.getParameter("description");
			Map<String, String> map = new HashMap<String, String>();
			map.put("Id", Id);
			map.put("BookName", BookName);
			map.put("CatgoryName", CatgoryName);
			map.put("Price", Price);
			map.put("Description", Description);
			if (!booklist.AddBook(map)) {
				System.out.println("add book process is wrong");
			}
			//System.out.println(Id);
		this.getServletContext().setAttribute("BookList", booklist);
		response.sendRedirect(request.getContextPath()+"/showBooks.jsp");
		doGet(request, response);
	}

}
