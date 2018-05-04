package com.imooc.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scae) {
		String name = scae.getName();
		String value = (String) scae.getValue();
		System.out.println("context attribute listener add name: " + name + " value : " + value);
	}

	public void attributeRemoved(ServletContextAttributeEvent scae) {
		String name = scae.getName();
		String value = (String) scae.getValue();
		System.out.println("context attribute listener remove name: " + name + " value : " + value);
	}

	public void attributeReplaced(ServletContextAttributeEvent scae) {
		String name = scae.getName();
		String value = (String) scae.getValue();
		System.out.println("context attribute listener replace name: " + name + " value : " + value);
	}

}
