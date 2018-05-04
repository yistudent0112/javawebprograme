package com.imooc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class MyFirstListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent sce)  { 
      System.out.println("First Listener Destroyed!");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("First Listener Initialized!");
    }
	
}
