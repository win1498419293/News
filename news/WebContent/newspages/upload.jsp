<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	tr{line-height:40px;}
</style>
<script type="text/javascript" lang="javascript" src="../js/jquery-3.1.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		//提交按钮
		$("input[type='button']").click(function(){
			//获取文件域
			var upload_files = $("input[name='nfile']");
			//判断文件域是否为空
			for(var i=0;i<upload_files.length;i++){
				if(upload_files.eq(i).val().length==0){
					alert("第"+(i+1)+"个文件不能为空!");
					return false;
				}
			}
			//提交
			$("#myform").submit();
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
    <h1 id="opt_type"> 上传文件： </h1>
	<form action="../newUpload?type=upload" method="post" id="myform" enctype="multipart/form-data">
		<table> 
			<tr>
				<td>上传文件1:</td>
				<td><input type="file" name="nfile" value="" id="" /></td>
			</tr>
			<tr>
				<td>上传文件2:</td>
				<td><input type="file" name="nfile" value="" id="" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="&nbsp;&nbsp;提&nbsp;交&nbsp;&nbsp;" onclick="imgcon()" />
				</td>
			</tr>
		</table>
	</form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
