package com.imooc.entity;

import java.util.ArrayList;
import java.util.List;

public class Excel {
private  String title;
private  List<Student>list=null;
private String message;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Excel() {
	list=new ArrayList<Student>();
}
	public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public List<Student> getList() {
	return list;
}

public void setList(List<Student> list) {
	this.list = list;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
