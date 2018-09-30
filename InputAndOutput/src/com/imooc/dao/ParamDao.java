package com.imooc.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

public class ParamDao {
	private Map<String, String> paramMap;
	private Map<String, FileItem> FileItemMap;

	public ParamDao() {
		paramMap = new HashMap<>();
		FileItemMap = new HashMap<>();
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public Map<String, FileItem> getFileItemMap() {
		return FileItemMap;
	}

	public void setFileItemMap(Map<String, FileItem> fileItemMap) {
		FileItemMap = fileItemMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
