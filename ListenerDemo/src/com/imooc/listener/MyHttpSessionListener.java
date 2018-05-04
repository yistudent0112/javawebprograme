package com.imooc.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	String SessionId=se.getSession().getId();
    	Date CurrentTime=new Date(se.getSession().getCreationTime());
    	System.out.println("session created SessionId : "+SessionId+" CurrentTime : "+CurrentTime);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	String SessionId=se.getSession().getId();
    	Date CurrentTime=new Date(se.getSession().getCreationTime());
    	System.out.println("session destroyed SessionId : "+SessionId+" CurrentTime : "+CurrentTime);
    }
	
}
