package com.imooc.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.Workbook;

import com.imooc.service.ExcelService;


public class ExportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Workbook workbook=ExcelService.exp(false);
		//����õ���Excel�ļ������������ʽ��1.ֱ��������������ȥ 2.���ļ�����������Ȼ���ṩһ����Ӧ�����ص�ַ
		//����һ    ֱ�ӽ��õ���Excel�ļ�������������ȥ�������ڴ���ͣ������������棬ͨ�������ֱ����ǰ��ҳ���ӡ
//		ServletOutputStream outputStream=response.getOutputStream();
//		response.setHeader("Content-Disposition", "attachment;filename=export.exl");
//		workbook.write(outputStream);
		//������   ���ļ��������������ṩ��Ӧ�����ص�ַ
		ServletOutputStream outputStream=response.getOutputStream();
		FileOutputStream fileOutputStream=new FileOutputStream(new File("F:\\JavaWeb����\\InputAndOutput\\export.exl"));
		workbook.write(fileOutputStream);
		FileInputStream fileInputStream=new FileInputStream(new File("F:\\JavaWeb����\\InputAndOutput\\export.exl"));
		byte []bytes=new byte[fileInputStream.available()];
	    fileInputStream.read(bytes);
	    outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
		fileInputStream.close();
		fileOutputStream.close();
		workbook.close();
	}

}
