package com.imooc.fliter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFliter implements Filter {
	private FilterConfig config;

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		System.out.println("destroy()~");

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//request.setCharacterEncoding(config.getInitParameter("CharacterEncoding"));
		System.out.println(config.getInitParameter("CharacterEncoding"));
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String LoginUser = (String) hrequest.getSession().getAttribute("username");
		if (LoginUser == null) {	
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag=1");
		   System.out.println("fail");
		} else {
			System.out.println(LoginUser); 
		}
		chain.doFilter(hrequest, hresponse);
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig Config) throws ServletException {
		this.config = Config;
		System.out.println("init()~");
	}

}
