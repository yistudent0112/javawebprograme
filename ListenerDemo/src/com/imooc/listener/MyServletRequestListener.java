package com.imooc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
      System.out.println("request listener destroyed");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		String Path = request.getRequestURI();
		String Par = request.getParameter("par");
		System.out.println("request listener initialized  Path : " + Path + " Par : " + Par);
	}

}
