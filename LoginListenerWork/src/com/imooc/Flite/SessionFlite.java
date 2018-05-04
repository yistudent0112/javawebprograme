package com.imooc.Flite;

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

public class SessionFlite implements Filter {

 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
HttpServletRequest hrequest=(HttpServletRequest)request;
HttpServletResponse hresponse=(HttpServletResponse)response;
//System.out.println("test");
String LoginUser=(String)hrequest.getSession().getAttribute("LoginUser");
if(LoginUser==null) {
	hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?fail=1");
}else {
		chain.doFilter(hrequest, hresponse);
}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
