package com.imooc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.imooc.service.WordService;

public class ExportWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getRequestDispatcher("WEB-INF/jsp/exportWord.jsp").forward(request,
//				response);
		request.setCharacterEncoding("utf-8");
		Map<String, String> map = new HashMap<>();
		map.put("${name}", request.getParameter("title"));
		map.put("${age}", request.getParameter("age"));
		map.put("${date}", request.getParameter("time"));
		XWPFDocument docx = WordService.exp(map);
		ServletOutputStream outputStream = response.getOutputStream();
		response.setHeader("Content-Disposition", "attachment;filename=export.docx");
		docx.write(outputStream);
		docx.close();
		outputStream.flush();
		outputStream.close();

	}

}
