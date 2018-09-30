package com.imooc.sso.servlet;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private String domains;

	@Override
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
	domains=config.getInitParameter("domains");
}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("/login".equals(request.getServletPath())) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String source = request.getParameter("source");
			if(Objects.equals(null, source)||Objects.equals("", source.trim())) {
				String refer=request.getHeader("referer");
				source=refer.substring(refer.indexOf("source=")+7 );
			}
			if (username != null && username.equals(password)) {
				String ticket = UUID.randomUUID().toString().replaceAll("-", "");
				System.out.println("**********************" + ticket);
				response.sendRedirect(source + "/main?ticket=" + ticket+"&domains="+domains);
			} else {
				request.setAttribute("source", source);
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}

		} else if ("/ssoLogin".equals(request.getServletPath())) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}else if(Objects.equals("/ssoLogout",request.getServletPath())) {
			String source=request.getParameter("source");
			if(Objects.equals(null, source)||Objects.equals("", source.trim())) {
				String refer=request.getHeader("referer");
				source=refer.substring(refer.indexOf("source=")+7 );
			}
			//System.out.println(source);
			String tempSource=source.substring(source.indexOf("SSO_WebApp"), source.indexOf("SSO_WebApp")+11);
			String domains1=domains.replace(tempSource+",", "").replace(","+tempSource, "").replace(tempSource, "");
			System.out.println(domains1);
			response.sendRedirect(source+"/logout?domains="+domains1);
			//response.sendRedirect(source + "/main?ticket=" +"test"+"&domains="+domains);
	
		}
	}

}
