package com.imooc.domain;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 用户注册的Servlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	   //数据的接收
	   //文件上传基本操作:

		try {
			   //1.创建一个磁盘文件项工厂对象
			DiskFileItemFactory diskfileitemfactory=new DiskFileItemFactory();
		   //2.创建一个核心解析类
			ServletFileUpload servletFileUpload=new ServletFileUpload(diskfileitemfactory);
		   //3.解析request请求，返回的是一个List集合，list集合中存放的FileItem对象
			List<FileItem> list=servletFileUpload.parseRequest(request);
			//4.遍历集合，获得每一个FileItem对象，看是表单项还是文件项
			for(FileItem fileitem:list) {
				//判断是上传文件还是普通表单项
				if(fileitem.isFormField()) {
					//代表的是表单项
					//接收表单项参数的值
					String name=fileitem.getFieldName();//获得表单项的name属性的值
					String value=fileitem.getString("utf-8");//获得表单项的值
					System.out.println(name+"   "+value);
				}else {
					//代表的是文件上传项
					//文件上传功能
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
     System.out.print("hello");
	}

}
