package com.imooc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.utils.BookCatgoryList;


public class CatgoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookCatgoryList bookCatgoryList=(BookCatgoryList)this.
				getServletContext().getAttribute("BookCatgoryList");
		String Id=request.getParameter("id");
		String Catgory=request.getParameter("catgoryName");
		String Description=request.getParameter("description");
		Map<String,String>map=new HashMap<String,String>();
		map.put("Id", Id);
		map.put("Name", Catgory);
		map.put("Description", Description);
		if(!bookCatgoryList.AddCatgory(map)) {
			System.out.println("add catgory process is wrong");
		}
		String []Catgorys=bookCatgoryList.GetCatgorys();
		this.getServletContext().setAttribute("Catgorys", Catgorys);
		this.getServletContext().setAttribute("BookCatgoryList", bookCatgoryList);
		response.sendRedirect(request.getContextPath()+"/addBook.jsp");
		doGet(request, response);
	}

}
