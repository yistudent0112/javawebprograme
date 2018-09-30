package com.imooc.util;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imooc.dao.ParamDao;
/*
 * ��request�н����ϴ��Ĳ������ļ�
 */
public class RequestUtil {
	public static ParamDao parseParam(HttpServletRequest request) {
		ParamDao result = new ParamDao();
		Map<String, String> paramMap = new HashMap<>();
		Map<String, FileItem> FileItemMap = new HashMap<>();
		System.out.println("������servlet��");
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		upload.setHeaderEncoding("utf-8");
		System.out.println("�Ѿ��������������");
		try {
			List<FileItem> fileItemList = upload.parseRequest(request);
			for (FileItem temp : fileItemList) {
				if (temp.isFormField()) {
					paramMap.put(temp.getFieldName(), temp.getString("utf-8"));
					System.out.println(temp.getFieldName() + "," + temp.getString("utf-8"));
				} else {
					System.out.println("����һ���ļ�");
					//temp.write(new File("F:/JavaWeb����/InputAndOutput/" + temp.getName()));
					FileItemMap.put(temp.getFieldName(), temp);
					System.out.println(temp.getFieldName());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setFileItemMap(FileItemMap);
		result.setParamMap(paramMap);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
