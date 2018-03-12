package com.imooc.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDb {
public static Map<String,Student>map=new HashMap<String,Student>();
static {
	map.put("110771010", new Student("110771010","ÕÔÃ÷","78"));
	map.put("110771011", new Student("110771011","ÀîÑ©","100"));
	map.put("110771012", new Student("110771012","º«Ã·Ã·","92"));
	map.put("110771013", new Student("110771013","´óĞÜ","80"));
	map.put("110771014", new Student("110771014","Àî¾²Ïã","90"));
	map.put("110771015", new Student("110771015","ÅÖ»¢","42"));
}
public static void main(String[]args) {
	//ArrayList a=new ArrayList();
	Student s1=new Student("110771010","ÕÔÃ÷","78");
	Student s2=new Student("110771011","ÀîÑ©","100");
	Student s3=new Student("110771012","º«Ã·Ã·","92");
	Student s4=new Student("110771013","´óĞÜ","80");
	Student s5=new Student("110771014","Àî¾²Ïã","90");
	Student s6=new Student("110771015","ÅÖ»¢","42");
	List <Student>l=new ArrayList<Student>();
	l.add(s1);
	l.add(s2);
	l.add(s3);
	l.add(s4);
	l.add(s5);
	l.add(s6);
for(int i=0;i<l.size();i++) {
	System.out.println(l.get(i));
}
	
	for(String key:map.keySet()) {
		System.out.println(map.get(key).getName());
	}

}
}
