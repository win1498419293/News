<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>下载主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	tr{line-height:40px;}
</style>
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
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;<a href="../destory">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.txt" %>
  <div id="opt_area">
    <h1 id="opt_type"> 下载文件： </h1>
	<a href="../Downlod?filename=sina.jpg">下载新浪网页面</a><br />
	<a href="../Downlod?filename=huanqiu.jpg">下载环球网页面</a>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
