package com.imooc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JSTLEL extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //1.首先创建一个List集合，我们往这个List集合中存放多条数据
		List<Map<String,String>>lists=new ArrayList<Map<String,String>>();
		Map<String,String>map1=new HashMap<String,String>();
		map1.put("BrandName", "联想笔记本");
		map1.put("location", "北京");
		map1.put("price", "4999");
		Map<String,String>map2=new HashMap<String,String>();
		map2.put("BrandName", "神州笔记本");
		map2.put("location", "上海");
		map2.put("price", "3999");
		lists.add(map1);
		lists.add(map2);
		//2.将存放多条的List集合放到request域中去
		request.setAttribute("list", lists);
		//3.跳转到4.jsp页面中去
		request.getRequestDispatcher("/4.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
