<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>乘法表</title>
</head>
<body>
<h1 align="center" style="宋体" >99乘法表</h1>
<%!
//返回九九乘法表对应对的HTML代码，通过表达式调用，在页面上显示
String PrintMultiTable1(){
	String s="";
	for(int i=1;i<10;i++){
		for(int j=1;j<=i;j++){
			s+=i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		s+="<br>";//这是换行标签
	}
	return s;
}
%>
<%! 
//Jsp内置out对象，使用脚本方式调用，打印九九乘法表
void PrintMultiTable2(JspWriter out) throws Exception{
	for(int i=1;i<10;i++){
		for(int j=1;j<=i;j++){
			out.print(i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		out.println("<br>");//这是换行标签
	}
}
%>
<%=PrintMultiTable1() %>
<%PrintMultiTable2(out); %>
</body>
</html>