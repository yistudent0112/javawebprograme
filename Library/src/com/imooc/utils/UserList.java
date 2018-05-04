package com.imooc.utils;

import java.util.HashMap;
import java.util.Map;

import com.imooc.domain.Book;
import com.imooc.domain.User;

/*
 * 
    * @ClassName: UserList  
    * @Description: TODO(��������ע���û���Ϣ��������)  
    * @author yi 
    * @date 2018��4��12��  
    *
 */

public class UserList {
/**
 * �������ע����û����û���
 */
private static Map<String, User>UserDB=new HashMap<String,User>();
/**
 * 
    * @Title: UserExits  
    * @Description: TODO(�ж��û��Ƿ����û����д���)  
    * @param @param user
    * @param @return    ����  
    * @return boolean    ��������  
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
    * @Description: TODO(��servlet���ã�������û����û�����ȥ�����ж��Ƿ�����е��û��ظ�)  
    * @param @param temp
    * @param @return    ����  
    * @return boolean    ��������  
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
    * @Description: TODO(��������ͨ��Id����һ���û�-�������ؽ��)  
    * @param @param username
    * @param @return    ����  
    * @return User    ��������  
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
