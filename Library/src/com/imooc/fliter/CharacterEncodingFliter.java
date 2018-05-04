package com.imooc.fliter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class CharacterEncodingFliter implements Filter {
private FilterConfig config;
    public FilterConfig getConfig() {
	return config;
}

public void setConfig(FilterConfig config) {
	this.config = config;
}

	/**
     * Default constructor. 
     */
    public CharacterEncodingFliter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding(config.getInitParameter("CharacterEncoding"));
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig Config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = Config;
	}

}
