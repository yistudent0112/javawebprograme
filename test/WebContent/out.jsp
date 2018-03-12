<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>out测试页面</title>
</head>
<body>
<h2>静夜思</h2>
<%
out.println("床前明月光<br>");
out.println("疑似地上霜<br>");
out.flush();
out.println("举头望明月<br>");
out.println("低头思故乡<br>");

%>
缓冲区大小：<%=out.getBufferSize() %><br>
缓冲区剩余大小:<%=out.getRemaining() %><br>
是否支持自动清除缓冲区功能:<%=out.isAutoFlush() %><br>
<%
String name="";
String password="";
Cookie [] cookie=request.getCookies();
if(cookie!=null&&cookie.length>0){
	for(Cookie temp:cookie){
		if(temp.getName().equals("name")){
            name=temp.getValue();
		}
		else if(temp.getName().equals("password")){
			password=temp.getValue();
		}
		
	}
}
%>
用户名:<%=name %><br>
密码:<%=password %><br>
</body>
</html>