package com.imooc.dao;

import org.apache.commons.fileupload.FileItem;

public class ImportWordDao {
	private String title;
	private FileItem word;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public FileItem getWord() {
		return word;
	}
	public void setWord(FileItem word) {
		this.word = word;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
