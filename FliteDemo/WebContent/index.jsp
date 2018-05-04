<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String servletflag=request.getParameter("flag");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<link href="form.css" rel="stylesheet" type="text/css"/>
 <script type="text/javascript">
  var flag='<%=servletflag%>'
  if(flag=='1'){
	  alert("您还没有登录用户")
  }
</script> 
</head>
<body>
   <form action="logon.jsp" method="post" class="smart-green">
     <h1>系统登录</h1>
     <label>
     <span>用户名:</span>
     <input type="text" name="username" />
     </label>
      <label>
     <span>密码:</span>
     <input type="password" name="password" />
     </label>
      <label>
     <input type="submit" value="提交" />
     </label>
   </form>
</body>
</html>