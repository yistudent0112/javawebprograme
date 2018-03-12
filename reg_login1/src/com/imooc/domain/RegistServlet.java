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
 * �û�ע���Servlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	   //���ݵĽ���
	   //�ļ��ϴ���������:

		try {
			   //1.����һ�������ļ��������
			DiskFileItemFactory diskfileitemfactory=new DiskFileItemFactory();
		   //2.����һ�����Ľ�����
			ServletFileUpload servletFileUpload=new ServletFileUpload(diskfileitemfactory);
		   //3.����request���󣬷��ص���һ��List���ϣ�list�����д�ŵ�FileItem����
			List<FileItem> list=servletFileUpload.parseRequest(request);
			//4.�������ϣ����ÿһ��FileItem���󣬿��Ǳ�����ļ���
			for(FileItem fileitem:list) {
				//�ж����ϴ��ļ�������ͨ����
				if(fileitem.isFormField()) {
					//������Ǳ���
					//���ձ��������ֵ
					String name=fileitem.getFieldName();//��ñ����name���Ե�ֵ
					String value=fileitem.getString("utf-8");//��ñ����ֵ
					System.out.println(name+"   "+value);
				}else {
					//��������ļ��ϴ���
					//�ļ��ϴ�����
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
