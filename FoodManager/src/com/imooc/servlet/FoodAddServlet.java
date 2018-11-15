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

import com.imooc.utils.UploadUtils;

public class FoodAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ݵĽ���
		// �ļ��ϴ���������:
		try {
			// ����һ��Map�������ڱ�����յ�������:
			Map<String, String> map = new HashMap<String, String>();
			// 1.����һ�������ļ��������

			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 2.����һ�����Ľ�����
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 3.����request���󣬷��ص���List���ϣ�List�����д�ŵ���FileItem����
			List<FileItem> list = servletFileUpload.parseRequest(request);
			// ����һ��List���ϣ����ڱ�����Ȥ��������:
			List<String> hobbyList = new ArrayList<String>();
			// 4.�������ϣ����ÿ��FileItem���ж��Ǳ�����ļ��ϴ���
			String url = null;
			for (FileItem fileItem : list) {
				// �ж��Ǳ�����ļ��ϴ���
				if (fileItem.isFormField()) {
					// ��ͨ����:
					// ���ձ��������ֵ:
					String name = fileItem.getFieldName(); // ��ñ����name���Ե�ֵ
					String value = fileItem.getString("UTF-8");// ��ñ����ֵ
					System.out.println(name + "    " + value);
					// ���ո�ѡ�������
					if ("Flavour".equals(name)) {
						String hobbyValue = fileItem.getString("UTF-8");
						// ���յ�һ��ֵ�������ֵ���뵽hobbyList������
						hobbyList.add(hobbyValue);
						hobbyValue = hobbyList.toString().substring(1, hobbyList.toString().length() - 1); // xxx,yyy
						// System.out.println(name+" "+hobbyValue);
						// �����õ����ݴ��뵽Map������:
						map.put(name, hobbyValue);
					} else {
						// �����ݴ��뵽map������:
						map.put(name, value);
					}
				} else {
					// �ļ��ϴ���:
					// �ļ��ϴ����ܣ�
					// ����ļ��ϴ������ƣ�
					String fileName = fileItem.getName();
					if (fileName != null && !"".equals(fileName)) {
						// ͨ����������Ψһ�ļ���:
						String uuidFileName = UploadUtils.GetUUIDFilename(fileName);
						// ����ļ��ϴ������ݣ�
						InputStream is = fileItem.getInputStream();

						// ����ļ��ϴ���·��:
						String path = this.getServletContext().getRealPath("/upload");
						// ���������Խӵ�������Ϳ�����:
						url = path + "\\" + uuidFileName;
						OutputStream os = new FileOutputStream(url);
						int len = 0;
						byte[] b = new byte[1024];
						while ((len = is.read(b)) != -1) {
							os.write(b, 0, len);
						}
						is.close();
						os.close();
						map.put("Path", url);
						// System.out.println("Path"+url);
						// ��·����Ϣ���뵽map��
					}

				}
			}
			if (FoodDaolmpl.addFood(map)) {
				//System.out.println(map.get("Path"));
				System.out.println("success");
			
				response.sendRedirect(request.getContextPath() + "/ShowFoodList.jsp");
			} else {
				System.out.println("fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
