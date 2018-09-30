package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imooc.dao.ImportExcelDao;
import com.imooc.dao.ImportWordDao;
import com.imooc.dao.ParamDao;
import com.imooc.entity.Word;
import com.imooc.service.WordService;
import com.imooc.util.RequestUtil;


public class ImportWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(ServletFileUpload.isMultipartContent(request)) {
		ParamDao param=RequestUtil.parseParam(request);
		ImportWordDao wordDao=new ImportWordDao();
		wordDao.setTitle(param.getParamMap().get("title"));
		wordDao.setWord(param.getFileItemMap().get("word"));
		Word word=WordService.imp(wordDao);
		request.setAttribute("word", word);
	}else {
		
	}
		request.getRequestDispatcher("WEB-INF/jsp/importWordResult.jsp").forward(request, response);
	}

}
