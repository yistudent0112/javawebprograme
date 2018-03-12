package com.pn;

public class UserControl {
 public boolean SelectByUserName(User u) {
	 boolean flag=false;
	 if("admin".equals(u.getName())&&"123456".equals(u.getPassword())) {
		 flag=true;
	 }
	 return flag;
 }
}
