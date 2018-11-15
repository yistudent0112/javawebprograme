package com.imooc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.Food;
import com.imooc.utils.FoodDaolmpl;

/**
 * Servlet implementation class SelectServlet
 */

public class SelectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	      String id=request.getParameter("foodName");
	        Map<String,String> temp=new HashMap<String,String>();
	        temp.put("FoodName", id);
	        //System.out.println(id);
	        if(FoodDaolmpl.GetFoodByName(temp) != null) {
	        	Food food=FoodDaolmpl.GetFoodByName(temp);
	        	//System.out.println(food);
	        	System.out.println(food.getPath());
	        	System.out.println(food.toString());
	        	///int index="/a/ss.jsaw".lastIndexOf("//");
	        	//int index="//a/ss.js".indexOf('\\');
	        	//int index=food.getPath().lastIndexOf("\\");
	        	//System.out.println(index);
	        	request.getSession().setAttribute("food", food);
	            System.out.println("success");
	            System.out.println(food.getPath());
	        	response.sendRedirect(request.getContextPath()+"/ShowFoodList.jsp");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
