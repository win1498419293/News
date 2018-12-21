<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" lang="javascript" src="../js/jquery-3.1.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		$("input[type=button]").click(function(){
			var tname = $("#tname");

			if(tname.val() == ""){
				alert("请输入主题名称！！");
				tname.focus();
				return false;
			}	
		});
		$("#tname").blur(function(){
			var name=$("#tname").val();
			var check = "check";
			if(!name.length==0){
			$.ajax({
				url:"../topic",
				type:"get",
				data:{name:name,toptype:check},
				dataType:"text",
				success:function(param){
					if(param=="true"){
						$("#show").html("该主题已有,不可用");
						return false;
					}else{
						$("#ti").click(function(){ 
							$("#myform").submit();
						});
					}
				}
			});
			}
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
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.txt" %>
  <div id="opt_area">
    <h1 id="opt_type"> 添加主题： </h1>
    <form action="../topic?toptype=add" method="post" id="myform">
      <p>
        <label> 主题名称 </label>
        <input name="tname" id="tname" type="text" class="opt_input" id="tname"/><label id="show"></label>
      </p>
      <input type="button" id="ti" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
