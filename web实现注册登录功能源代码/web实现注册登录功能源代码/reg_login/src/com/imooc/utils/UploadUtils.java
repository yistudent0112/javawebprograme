 package com.imooc.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 * @author jt
 *
 */
public class UploadUtils {

	/**
	 * 生成唸�的文件名:
	 */
	public static String getUUIDFileName(String fileName){
		// 将文件名的前面部分进行截取：xx.jpg   --->   .jpg
		int idx = fileName.lastIndexOf(".");
		String extention = fileName.substring(idx);
		String uuidFileName = UUID.randomUUID().toString().replace("-", "")+extention;
		return uuidFileName;
	}
	
	public static void main(String[] args) {
		System.out.println(getUUIDFileName("1.jpg"));
	}
}
