package com.imooc.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imooc.utils.FoodDaolmpl;
import com.imooc.utils.UploadUtils;


public class FoodDeleteServlet extends HttpServlet {      

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        String id=request.getParameter("id");
        Map<String,String> temp=new HashMap<String,String>();
        temp.put("FoodId", id);
        if(FoodDaolmpl.DeleteFood(temp)) {
        	System.out.println("success");
        	response.sendRedirect(request.getContextPath()+"/ShowFoodList.jsp");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
