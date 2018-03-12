<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--一个计算1到100的和的程序--%>
求和程序
<%!
String str="count the sum of 1 to 100";
int  getSum(){
	int sum=0;
	for(int i=0;i<101;i++)
		sum=sum+i;
	return sum;
}
%>
<%!int i=0; %>
<%=i %>
<br>
<%out.println(this.str); %>
<br>
<%=this.getSum() %>
</body>
</html>