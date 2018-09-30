package com.imooc.sso.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/UserFilter")
public class UserFilter implements Filter {
	private String app;
	private String server;

	public UserFilter() {

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(Objects.equals("/ssoLogout", ((HttpServletRequest)request).getServletPath())) {
			System.out.println("*********************");
			System.out.println(server);
			System.out.println("*********************");
			((HttpServletResponse) response).sendRedirect(server + "/ssoLogout?source=" + app);
			return ;
		}
		String ticket = null;
		if (null != ((HttpServletRequest) request).getCookies()) {
			for (Cookie cookie : ((HttpServletRequest) request).getCookies()) {
				if (Objects.equals(cookie.getName(), "Ticket_Granting_Ticket")) {
					ticket = cookie.getValue();
					break;
				}
			}
		}
		if (!Objects.equals(null, ticket)) {
			// 需要进行用户校验，如果不是用户或者是非法访问应该跳回到登录页面
			// 判断超时时间
			String[] values = ticket.split(":");
			ticket = request.getParameter("ticket");
			if (Long.valueOf(values[1]) < System.currentTimeMillis()) {

				if (Objects.equals(null, ticket)) {
					((HttpServletResponse) response).sendRedirect(server + "/ssoLogin?source=" + app);
					return;
				} else {
					ticket = ticket + ":" + (System.currentTimeMillis() + 10000);
					((HttpServletResponse) response).addCookie(new Cookie("Ticket_Granting_Ticket", ticket));
					chain.doFilter(request, response);
					return;
				}
			}
			chain.doFilter(request, response);
			return;
		}
		ticket = request.getParameter("ticket");
		if (!Objects.equals(null, ticket) && !Objects.equals("", ticket.trim())) {
			ticket = ticket + ":" + (System.currentTimeMillis() + 10000);
			((HttpServletResponse) response).addCookie(new Cookie("Ticket_Granting_Ticket", ticket));
			chain.doFilter(request, response);
		} else {
//			System.out.println("*********************");
//			System.out.println(server);
//			System.out.println("*********************");
			((HttpServletResponse) response).sendRedirect(server + "/ssoLogin?source=" + app);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		app = fConfig.getInitParameter("app");
		server = fConfig.getInitParameter("server");
	}

}
