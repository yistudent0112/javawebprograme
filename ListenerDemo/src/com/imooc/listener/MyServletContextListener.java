package com.imooc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         String AppName=(String)sce.getServletContext().getAttribute("AppName");
         String Version=(String)sce.getServletContext().getAttribute("Version");
         System.out.println("context listener destroyed AppName : "+AppName+" Version : "+Version);
    }

    public void contextInitialized(ServletContextEvent sce)  { 
     String AppName=sce.getServletContext().getInitParameter("app_name");
     String Version=sce.getServletContext().getInitParameter("version");
     
     sce.getServletContext().setAttribute("AppName", AppName);
     sce.getServletContext().setAttribute("Version", Version);
     System.out.println("context listener initialized AppName : "+AppName+" Version : "+Version);
    }
	
}
