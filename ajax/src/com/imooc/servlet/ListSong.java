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
      //1.��ȡajax���ݹ����Ĳ�����Ϣ
		String flag=request.getParameter("flag");
	  //2.��Ҫ���صĲ�����Ϣ
		String data="";
		if("1".equals(flag)) {
			data="����<br>����<br>�������";
		}else if("2".equals(flag)) {
			data="ǧǧ�ڸ�<br>ɵŮ<br>����";
		}else if("3".equals(flag)) {
			data="һ��첼<br>����ɮ<br>�³���·�ϵ�ҡ��";
		}else {
			data="�������flag��������";
		}
	  //3.����Ϣ���ݻ�д��ajax
		response.getOutputStream().write(data.getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        doGet(request,response);
	}

}
