package com.imooc.sso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String servers;
	//新建一个大小为10的线程池
	private ExecutorService service=Executors.newFixedThreadPool(10);
       private void syncCookie(String server,String ticket,String method) {
    	   service.submit(new Runnable() {
			
			@Override
			public void run() {
				HttpPost httpPost=new HttpPost("http://localhost:8888/"+server+"/"+method+"?ticket="+ticket);
				System.out.println(server);
				CloseableHttpClient httpClient=null;
				CloseableHttpResponse response=null;
				try {
				httpClient=HttpClients.createDefault();
				System.out.println(httpPost.getURI());
				response=httpClient.execute(httpPost);
				HttpEntity entity=response.getEntity();
				String responseContext=EntityUtils.toString(entity, "utf-8");
				System.out.println("================="+responseContext);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(response!=null) {
						try {
							response.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(httpClient!=null) {
						try {
							httpClient.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Objects.equals("/main",request.getServletPath() )) {
			String domains=request.getParameter("domains");
			if(!Objects.equals(null, domains)) {
				servers=domains;
			}
			String ticket=request.getParameter("ticket");
			if(!Objects.equals(domains, null)&&!Objects.equals(null, ticket)) {
				for(String server:domains.split(",")) {
					if(!Objects.equals(null, server)&&!Objects.equals("",server.trim())) {
						syncCookie(server,ticket,"setCookie");
					}
				}
				}
			request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
		}
		else if(Objects.equals("/setCookie", request.getServletPath())) {
			String ticket=request.getParameter("ticket");
			response.addCookie(new Cookie("Ticket_Granting_Ticket", ticket));
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/text;charset=utf-8");
			PrintWriter out=null;
			try{
			out=response.getWriter();
			out.write("ok");
			}catch(IOException exception) {
				exception.printStackTrace();
			}finally{
				if(null!=out) {
					out.close();
				}
			}
		}else if(Objects.equals("/logout", request.getServletPath())) {
			Cookie cookie=new Cookie("Ticket_Granting_Ticket", null);
			cookie.setMaxAge(0);
		    response.addCookie(cookie);
		   if(servers!=null) {
			   for(String server:servers.split(",")) {
				   if(!Objects.equals(server, null)&&!Objects.equals(server.trim(), null)) {
					   syncCookie(server, "","removeCookie");
				   }
			   }
		   }
		   request.getRequestDispatcher("/WEB-INF/views/logout.jsp").forward(request, response);;
		}else if(Objects.equals("/removeCookie", request.getServletPath())) {
			Cookie cookie=new Cookie("Ticket_Granting_Ticket", null);
			cookie.setMaxAge(0);
		    response.addCookie(cookie);
		    response.setCharacterEncoding("utf-8");
			response.setContentType("application/text;charset=utf-8");
		    PrintWriter out=null;
			try{
			out=response.getWriter();
			out.write("ok");
			}catch(IOException exception) {
				exception.printStackTrace();
			}finally{
				if(null!=out) {
					out.close();
				}
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
