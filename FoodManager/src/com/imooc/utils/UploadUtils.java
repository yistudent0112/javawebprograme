package com.imooc.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;




public class UploadUtils {
private static Map<String,String>Foodinfo=new HashMap<String,String>();
public static void UploadFile(HttpServletRequest request,String UploadDirectory)
		throws ServletException {

 try {
		//1.创建一个磁盘文件项工厂对象
	 DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
	 //2.创建一个核心解析类
	 ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
	 //3.解析request请求，请求返回的是list对象，list中存储的是FileItem对象
	List<FileItem>list=servletFileUpload.parseRequest(request);
	String url=null;
	for(FileItem fileItem:list) {
		//处理非文件项属性
		if(fileItem.isFormField()) {
			String name=fileItem.getFieldName();
			String value=fileItem.getString("utf-8"); 
			System.out.println("name: "+name+" value: "+value);
			Foodinfo.put(name, value);
		}else {
			//文件上传项：
			//完成文件上传功能
			//获得文件上传的名字
			String fileName=fileItem.getString();
			if(fileName!=null&&!"".equals(fileName)) {
				//通过函数获得唯一的文件名
				String UUIDFileName=GetUUIDFilename(fileName);
				//获得文件上传的数据
				InputStream in=fileItem.getInputStream();
				//获得文件上传的路径
				String path="./update";
				url=path+"//"+UUIDFileName;
				OutputStream out=new FileOutputStream(url);
				byte[] b=new byte[1024];
				int length=0;
				while((length=in.read(b))!=-1) {
					out.write(b, 0, length);
				}
				in.close();
				out.close();
			}
		}
	}
} catch (FileUploadException | IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public static String GetUUIDFilename(String fileName) {
	int index=fileName.lastIndexOf(".");
	String extention=fileName.substring(index);
	String uuidFileName=UUID.randomUUID().toString().replaceAll("-", "")+extention;
	return uuidFileName;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
