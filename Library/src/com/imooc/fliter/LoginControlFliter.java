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


public class LoginControlFliter implements Filter {


	/**
     * Default constructor. 
     */
    public LoginControlFliter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String LoginUser = (String) hrequest.getSession().getAttribute("LoginUser");
		if (LoginUser == null) {	
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?wrong=2");
		   System.out.println("fail");
		} else {
			//System.out.println(LoginUser);
		}
		chain.doFilter(hrequest, hresponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
