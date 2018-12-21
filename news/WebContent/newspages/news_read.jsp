<%@page import="cn.jbit.news.bean.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;<a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.txt" %>
  <jsp:useBean id="biz" class="cn.jbit.news.newsuserbiz.impl.NewsBizImpl"/>
   <div id="opt_area">
    <h1 id="opt_type"> 最新头条： </h1>
    <ul class="classlist">
     <%
  List<News>li=biz.query_news(null);
    if(li!=null){
    for(News list:li){
    %>
    <li><a href="../newsServlte?data=link&nid=<%=list.getNid() %>"><%=list.getNtitle() %></a></li>
    <% 
    }
    }
    %>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
