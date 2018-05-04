package com.imooc.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.imooc.cache.LoginCache;


public class LoginSessionListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
	private static final String LOGIN_USER="LoginUser";
    public LoginSessionListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String AttrName=se.getName();
         if(AttrName.equals(LOGIN_USER)) {
        	 String ValueName=(String)se.getValue();
        	 HttpSession Session=se.getSession();
        	 String SessionId=Session.getId();
        	 
        	 String SessionId2=LoginCache.GetSessionIdByUsername(ValueName);
        	 if(SessionId2==null) {
        		 
        	 }else {
        		HttpSession Session2=LoginCache.GetSessionBySessionId(SessionId2);
        		Session2.invalidate();
        	 }
        	 LoginCache.SetSessionIdByUsername(ValueName, SessionId);
    		 LoginCache.SetSessionBySessionId(SessionId, Session);
         }
    }


    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
