package com.imooc.homework;
public class Student {
private String StudentNumber;
private String name;
private String score;
public Student(String studentNumber, String name, String score) {
	super();
	StudentNumber = studentNumber;
	this.name = name;
	this.score = score;
}
public String getStudentNumber() {
	return StudentNumber;
}
public void setStudentNumber(String studentNumber) {
	StudentNumber = studentNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public String toString() {
	return "StNumber is "+StudentNumber+".Name is "
     +name+".Score is "+score;
}
}
