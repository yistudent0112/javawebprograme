package com.imooc.model;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class User implements HttpSessionBindingListener {

   private String UserName;
   private String Password;
    public User() {
        // TODO Auto-generated constructor stub
    }

    public void valueBound(HttpSessionBindingEvent event)  { 
         String user=event.getName();
         System.out.println("bound user : "+user);
    }

    public void valueUnbound(HttpSessionBindingEvent event)  { 
        String user=event.getName();
        System.out.println("unbound user : "+user);
    }

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
