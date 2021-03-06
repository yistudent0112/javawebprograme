package com.imooc.servlet;

import com.imooc.utils.*;

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

/**
 * Servlet implementation class FoodUpdateServlet
 */

public class FoodUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		// 数据的接收
		// 文件上传基本操作:
		try {
			// 定义一个Map集合用于保存接收到的数据:
			Map<String,String> map = new HashMap<String,String>();
			// 1.创建一个磁盘文件项工厂对象
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 2.创建一个核心解析类
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 3.解析request请求，返回的是List集合，List集合中存放的是FileItem对象
			List<FileItem> list = servletFileUpload.parseRequest(request);
			// 定义一个List集合，用于保存兴趣爱好数据:
			List<String> hobbyList = new ArrayList<String>();
			// 4.遍历集合，获得每个FileItem，判断是表单项还是文件上传项
			String url = null;
			for (FileItem fileItem : list) {
				// 判断是表单项还是文件上传项
				if(fileItem.isFormField()){
					// 普通表单项:
					// 接收表单项参数的值:
					String name = fileItem.getFieldName(); // 获得表单项的name属性的值
					String value = fileItem.getString("UTF-8");// 获得表单项的值
					System.out.println(name+"    "+value);
					// 接收复选框的数据
					if("Flavour".equals(name)){
						String hobbyValue = fileItem.getString("UTF-8");
						// 接收到一个值，将这个值存入到hobbyList集合中
						hobbyList.add(hobbyValue);
						hobbyValue = hobbyList.toString().substring(1, hobbyList.toString().length()-1); // xxx,yyy
						//System.out.println(name+"     "+hobbyValue);
						// 将爱好的数据存入到Map集合中:
						map.put(name, hobbyValue);
					}else{
						// 将数据存入到map集合中:
						map.put(name, value);
					}
				}else{
					// 文件上传项:
					// 文件上传功能：
					// 获得文件上传的名称：
					String fileName = fileItem.getName();
					if(fileName !=null && !"".equals(fileName)){
						// 通过工具类获得唯一文件名:
						String uuidFileName = UploadUtils.GetUUIDFilename(fileName);
						// 获得文件上传的数据：
						InputStream is = fileItem.getInputStream();
					
						// 获得文件上传的路径:
						String path = this.getServletContext().getRealPath("/upload");
						// 将输入流对接到输出流就可以了:
						url = path+"\\"+uuidFileName;
						OutputStream os = new FileOutputStream(url);
						int len = 0;
						byte[] b = new byte[1024];
						while((len = is.read(b))!=-1){
							os.write(b, 0, len);
						}
						is.close();
						os.close();
					   }
				
				}
			}
			if(FoodDaolmpl.UpdateFood(map)) {
				System.out.println("success");
				response.sendRedirect(request.getContextPath()+"/ShowFoodList.jsp");
			}else {
				System.out.println("fail");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
