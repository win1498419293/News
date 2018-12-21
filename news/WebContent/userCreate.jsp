<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" language="javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" language="javascript" >
$(function(){
	$("#userName").blur(function(){
	var name=$("#userName").val();
	var check = "check";
	if(!name.length==0){
		$.ajax({
			url:"register",
			type:"get",
			data:{name:name,type:check},
			dataType:"text",
			success:function(param){
				if(param=="true"){
					$("#lib").html("该用户名可不用");
					return false;
				}else{
					$("#lib").html("该用户名可用");
					$(".page-btn").click(function(){
						$("#registerFrm").submit();
					});
				}
			}
		});
	}
});
});
</script>
<title>新闻项目</title>
</head>
<body>
<form name="registerFrm" id="registerFrm" action="register?type=reg" method="post"> 
<!-- <form name="registerFrm" id="registerFrm" action="doUserCreate.jsp" method="post"> -->
	<table class="tb" border="0" cellspacing="5" cellpadding="0" align="center">
		<tr><td align="center" colspan="2" style="text-align:center;" class="text_tabledetail2">新闻用户注册</td></tr>
		<tr>
			<td class="text_tabledetail2">用户名:</td>
			<td><input type="text" name="userName" id="userName" value=""/></td>
			<td><label id="lib"></label></td>
		</tr>
		<tr>
			<td class="text_tabledetail2">密码:</td>
			<td><input type="password" name="password" value=""/></td>
		</tr>
		<tr>
			<td class="text_tabledetail2">email:</td>
			<td><input type="text" name="email" value=""/></td>
		</tr>
		<tr>
			<td class="text_tabledetail2">用户类型:</td>
			<td>
				<select name="userType">
					<option value="0">普通用户</option>
					<option value="1">管理员用户</option>
				</select>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;" colspan="2">				
				<button type="button" class="page-btn" name="save">注册</button>
				<button type="button" class="page-btn" name="return" onclick="javascript:location.href='<%=request.getContextPath() %>/index.jsp'">返回</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
