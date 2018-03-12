<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.imooc.homework.*,java.util.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生成绩表</title>
</head>
<body>
<h3 align="center">学生成绩表单</h3>
<hr>
<table align="center" border="1"width="500px">

  <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>成绩</th>
  </tr>
  <%
  Map<String ,Student>student=StudentDb.map;
  for(String key:student.keySet()){
  %>
  <tr>
    <td><%=student.get(key).getStudentNumber()%></td>
    <td><%=student.get(key).getName()%></td>
    <td><%=student.get(key).getScore() %></td>
  </tr>
<%
  }
%>
<%

Student s1=new Student("110771010","赵明","78");
Student s2=new Student("110771011","李雪","100");
Student s3=new Student("110771012","韩梅梅","92");
Student s4=new Student("110771013","大熊","80");
Student s5=new Student("110771014","李静香","90");
Student s6=new Student("110771015","胖虎","42");
List <Student>l=new ArrayList<Student>();
l.add(s1);
l.add(s2);
l.add(s3);
l.add(s4);
l.add(s5);
l.add(s6);

for(int i=0;i<l.size();i++){


%>
序号：
<%=i+1 %>
<%=l.get(i) %>
<hr>
<%
} 
%>
</table>
</body>
</html>