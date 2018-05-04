package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ListSong extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
      //1.获取ajax传递过来的参数信息
		String flag=request.getParameter("flag");
	  //2.需要返回的参数信息
		String data="";
		if("1".equals(flag)) {
			data="稻香<br>晴天<br>告白气球";
		}else if("2".equals(flag)) {
			data="千千阙歌<br>傻女<br>七友";
		}else if("3".equals(flag)) {
			data="一块红布<br>假行僧<br>新长征路上的摇滚";
		}else {
			data="传入参数flag出现问题";
		}
	  //3.将信息数据会写给ajax
		response.getOutputStream().write(data.getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        doGet(request,response);
	}

}
