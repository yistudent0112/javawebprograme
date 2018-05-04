<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.imooc.servlet.*,com.imooc.domains.*,java.util.*" %>
<%
    String name=(String) session.getAttribute("username"); 

    String servletflag=request.getParameter("servletflag");
    
    List<Message>Messages=(List<Message>)session.getAttribute("messages");
    
    String test=(String)session.getAttribute("test");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息显示页面</title>
<link href="form.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
  var flag='<%=servletflag%>'
  if(flag=='1'){
	  alert('留言成功');
  }
  </script>
</head>
<body>
   <form action="/FliteDemo/MessageServlet" method="post" class="smart-green">
   <h1>留言板</h1>
   <label>
   <span>留言人:</span>
   <input type="text" name="user" value="<%=name%>" readonly="readonly"/>
   </label>
   
    <label>
   <span>标题:</span>
   <input type="text" name="title" value="" />
   </label>
   
    <label>
   <span>内容:</span>
   <textarea  name="content" value="" ></textarea>
   </label>
   
   <label>
   <input type="submit" value="提交"/>
   </label>
   </form>
   
   <br>
   <form>
     <table width="85%" align="center">
      <tr> 
        <td width="15%">留言人</td>
        <td width="15%">标题</td>
        <td width="70%">内容</td>
      </tr>
      <%
      if(Messages!=null){
      for(Message m:Messages){
      %>
     
      <tr>
           
        <td><%=name %></td>
        <td><%=m.getTitle() %></td>
        <td><%=m.getContent() %></td>
   
      </tr>
      <% 
      } 
      }
      %>
      
     </table>
   </form>
</body>
</html>