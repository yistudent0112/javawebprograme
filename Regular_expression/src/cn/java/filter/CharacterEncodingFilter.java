package cn.java.filter;

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


public class CharacterEncodingFilter implements Filter {
  private FilterConfig config;

	public FilterConfig getConfig() {
	return config;
}


public void setConfig(FilterConfig config) {
	this.config = config;
}


	public void destroy() {
		System.out.println("destroy()~");
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    response.setCharacterEncoding(config.getInitParameter("CharacterEncoding"));
		HttpServletRequest hrequest = (HttpServletRequest) request;		
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String username=(String)hrequest.getSession().getAttribute("username");
		/*if(username==null){
			System.out.println("fail");
			hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?flag=0");
		}else {
			System.out.println("success");
			chain.doFilter(hrequest, hresponse);
		}*/
		chain.doFilter(request, response);
	}


	public void init(FilterConfig Config) throws ServletException {
		this.config=Config;
		System.out.println("init()~");
		// TODO Auto-generated method stub
	}

}
