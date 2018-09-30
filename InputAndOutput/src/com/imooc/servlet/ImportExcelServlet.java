package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imooc.dao.ImportExcelDao;
import com.imooc.dao.ParamDao;
import com.imooc.entity.Excel;
import com.imooc.service.ExcelService;
import com.imooc.util.RequestUtil;

/**
 * Servlet implementation class ImportExcelServlet
 */
public class ImportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ImportExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			ParamDao param=RequestUtil.parseParam(request);
            ImportExcelDao excelDao=new ImportExcelDao();
            excelDao.setTitle(param.getParamMap().get("title"));
            excelDao.setExcel(param.getFileItemMap().get("excel"));
			Excel excel=ExcelService.imp(excelDao);
			request.setAttribute("excel", excel);
		}else {
			
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/importExcelResult.jsp").forward(request, response);
	}

}
