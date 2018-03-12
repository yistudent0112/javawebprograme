<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>request页面</title>
</head>
<body>
<h2>request页面</h2>
<br>
<%
request.setCharacterEncoding("utf-8");
%>
用户账号:<%=request.getParameter("username") %><br>
用户爱好:
<%
if(request.getParameterValues("favourite")!=null){
String[] favourite=request.getParameterValues("favourite");
for(int i=0;i<favourite.length;i++){
	out.print(favourite[i]);
	out.print("&nbsp&nbsp");
}
}
%><br>
请求体的MIME类型:<%=request.getContentType() %><br>
请求体的协议类型和版本号:<%=request.getProtocol() %><br>
接受请求的服务器主机号:<%=request.getServerName() %><br>
服务器端口号:<%=request.getServerPort() %><br>
服务器的请求路径:<%=request.getServletPath() %><br>
客户端地址:<%=request.getRemoteAddr() %><br>
</body>
</html>