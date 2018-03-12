<%@ page language="java" contentType="text/html; charset=utf-8"
  errorPage="error.jsp"  pageEncoding="utf-8" import="com.imooc.bin.*,com.imooc.db.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录页面执行页</title>
</head>
<body>

<!-- 获取账号及密码信息，通过调用DButil中的方法来判断账号和密码时候匹配
     1.密码正确，即函数返回值为true，输出正确登录页面
     2.密码错误， 即函数返回值位false，输出错误页面
     request：获取请求信息，包括请求细节
     getParameter(String name)：可以通过控件的name属性来获取控件的内容    
     
     out：输出流对象，输出制定的信息。
     println();
 -->
 <%
 String password=request.getParameter("password");

 String account=request.getParameter("account");
 
 Emp emp=new Emp(account,null,password,null);
 
 Map <String,Emp>map=Dbutil.map;
 
 if(Dbutil.SelectEmpByAccountAndPassword(emp)){
session.setAttribute("account", account);
Object o=application.getAttribute("count");
if(o ==null){
	application.setAttribute("count", 1);
}else{
	int count=Integer.parseInt(o.toString());
	application.setAttribute("count", count+1);
}
 %>
 <h3 align="right">访问量：<%=application.getAttribute("count") %></h3>
 <h3 align="right">登录账户：<%=session.getAttribute("account") %></h3>
 <h3>字符编码集的格式为：<%=response.getCharacterEncoding() %></h3>
  <h3 align="center">欢迎来到人事管理页面</h3>
  <table align="center"border="1"width="500px">
  <tr>
        <td>
        账号：
        </td>
        <td>
       姓名： 
        </td>
        <td>
      邮箱：  
        </td>
              <td>
        修改：
        </td>
  </tr>
  <%
  for(String key:map.keySet()){
	  %>
   <tr>
        <td>
<%=map.get(key).getAccount() %>
        </td>
        <td>
<%=map.get(key).getName() %>
        </td>
        <td>
<%=map.get(key).getEmail() %>  
        </td>
        <td>
        <!-- 
        相邻两个jsp页面传递数据的时候，通过url参数的方式来传递。
        格式：
        资源？key=value&key=value
         -->
        <a href="update.jsp?account=<%=map.get(key).getAccount()%>&name=<%=map.get(key).getName()%>
&email=<%=map.get(key).getEmail()%>">修改</a>
        </td>
  </tr>
	  <% 
  }
  %>
</table>
<% 
 }else{
throw new Exception("账户密码错误");
 }
 %>
</body>
</html>