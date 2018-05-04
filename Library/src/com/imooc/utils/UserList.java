package com.imooc.utils;

import java.util.HashMap;
import java.util.Map;

import com.imooc.domain.Book;
import com.imooc.domain.User;

/*
 * 
    * @ClassName: UserList  
    * @Description: TODO(用来存贮注册用户信息的数据类)  
    * @author yi 
    * @date 2018年4月12日  
    *
 */

public class UserList {
/**
 * 用来存放注册过用户的用户表
 */
private static Map<String, User>UserDB=new HashMap<String,User>();
/**
 * 
    * @Title: UserExits  
    * @Description: TODO(判断用户是否在用户表中存在)  
    * @param @param user
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
 */
public static boolean UserExits(User user) {
	boolean flag=false;
	if(UserDB.containsKey(user.getUsername())) {
		flag=true;
	}
	return flag;
}
/**
 * 
    * @Title: AddUser  
    * @Description: TODO(给servlet调用，来添加用户到用户表中去，并判断是否与表中的用户重复)  
    * @param @param temp
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
 */
public static boolean AddUser(Map<String,String> temp) {
	boolean flag=false;
	User user=new User();
	user.setUsername(temp.get("Username"));
	user.setPassword(temp.get("Password"));
	user.setPhoneNumber(temp.get("Phone"));
	user.setEmail(temp.get("Email"));
	if(!UserExits(user)) {
		UserDB.put(user.getUsername(), user);
		flag=true;
	}
	return flag;
}
/**
 * 
    * @Title: FindUser  
    * @Description: TODO(在数据中通过Id查找一个用户-，并返回结果)  
    * @param @param username
    * @param @return    参数  
    * @return User    返回类型  
    * @throws
 */
public static User FindUser(String username) {
	User temp=null;
	temp=UserDB.get(username);
	return temp;
}
public static boolean UserMatch(User temp) {
	boolean flag=false;
	User u=FindUser(temp.getUsername());
	if((u.getUsername().equals(temp.getUsername()))&&(u.getPassword().equals(temp.getPassword()))) {
		flag=true;
	}
	return flag;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
