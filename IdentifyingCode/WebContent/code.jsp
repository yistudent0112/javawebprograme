<%@page import="com.imooc.code.CharacterCode"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
//1.清空浏览器的缓存，因为浏览器会对加载过的图片进行自动记忆，记忆以后文件就不会与服务器发生交互，就会导致加载失效的结果
response.setHeader("pragma", "no-cache");
response.setHeader("cache-control", "no-cache");
response.setHeader("expires", "0");
//2.调用生成验证码的工具类
String word=CharacterCode.DrawImageVerificate(response);
session.setAttribute("code",word);
//3.如何解决getoutputstream异常问题
out.clear();
out=pageContext.pushBody();
%>