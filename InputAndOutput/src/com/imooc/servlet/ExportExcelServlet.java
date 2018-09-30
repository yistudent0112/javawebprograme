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
		//针对拿到的Excel文件有两种输出方式：1.直接输出到输出流中去 2.将文件保存下来，然后提供一个对应的下载地址
		//方法一    直接将拿到的Excel文件输出到输出流中去，即在内存中停留，不经过外存，通过输出流直接向前端页面打印
//		ServletOutputStream outputStream=response.getOutputStream();
//		response.setHeader("Content-Disposition", "attachment;filename=export.exl");
//		workbook.write(outputStream);
		//方法二   将文件保存下来，再提供对应的下载地址
		ServletOutputStream outputStream=response.getOutputStream();
		FileOutputStream fileOutputStream=new FileOutputStream(new File("F:\\JavaWeb程序\\InputAndOutput\\export.exl"));
		workbook.write(fileOutputStream);
		FileInputStream fileInputStream=new FileInputStream(new File("F:\\JavaWeb程序\\InputAndOutput\\export.exl"));
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
