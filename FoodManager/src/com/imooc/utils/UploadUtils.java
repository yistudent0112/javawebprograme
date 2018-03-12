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
		//1.����һ�������ļ��������
	 DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
	 //2.����һ�����Ľ�����
	 ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
	 //3.����request�������󷵻ص���list����list�д洢����FileItem����
	List<FileItem>list=servletFileUpload.parseRequest(request);
	String url=null;
	for(FileItem fileItem:list) {
		//������ļ�������
		if(fileItem.isFormField()) {
			String name=fileItem.getFieldName();
			String value=fileItem.getString("utf-8"); 
			System.out.println("name: "+name+" value: "+value);
			Foodinfo.put(name, value);
		}else {
			//�ļ��ϴ��
			//����ļ��ϴ�����
			//����ļ��ϴ�������
			String fileName=fileItem.getString();
			if(fileName!=null&&!"".equals(fileName)) {
				//ͨ���������Ψһ���ļ���
				String UUIDFileName=GetUUIDFilename(fileName);
				//����ļ��ϴ�������
				InputStream in=fileItem.getInputStream();
				//����ļ��ϴ���·��
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
