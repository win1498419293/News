<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻图片</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" language="javascript">
	$(function(){
		//图片索引
		var pid = 0;
		function getPhoto(){
			$.ajax({
				url : "../photo",
				type : "get",
				data : {pid:pid},
				dataType : "text",
				success : function(param){
					$("#photo").attr("src",param);
				}
			});
		}
		
		//上一张
		$("#prev").click(function(){
			pid = (pid - 1 + 5) %5;
			getPhoto();
		});
		
		//下一张
		$("#next").click(function(){
			pid = (pid + 1 + 5) %5;
			getPhoto();
			
		});
	});
</script>
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
  <div id="opt_area">
   <table border="0" bgcolor="#c0c0c0" width="300px" height="240px">
	<tr>
		<td colspan="2" align="center"><h2>电子相册</h2></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><img id="photo" src="../images/photo1.jpg"></td>
	</tr>
	<tr>
		<td align="center"><span id="prev" style="cursor:hand;">上一张</span></td>
		<td align="center"><span id="next" style="cursor:hand;">下一张</span></td>
	</tr>
</table>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
