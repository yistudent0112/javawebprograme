package com.imooc.util;

import java.util.Date;
/*
 * 
    * @ClassName: Course  
    * @Description: TODO(�γ����ݳ�����)  
    * @author yi 
    * @date 2018��10��31��  
    *
 */
public class Course {
	public int CourseId;
	public String CourseName;
	public String CourseCategory;
	public String CourseDesp;
	public Date CreateTime;

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseCategory() {
		return CourseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		CourseCategory = courseCategory;
	}

	public String getCourseDesp() {
		return CourseDesp;
	}

	public void setCourseDesp(String courseDesp) {
		CourseDesp = courseDesp;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
