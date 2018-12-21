<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html >
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
			//提交
			$("#myform").submit();
		});
	});
</script>
</head>

<body>
	<%@include file="console_element/top.jsp" %>
<div id="main">
 <%@include file="console_element/left.txt"  %>
  <div id="opt_area">
    <h1 id="opt_type">修改主题： </h1>
    <form action="../topic?toptype=update" method="post" id="myform">
      <p>
        <label>主题名称 </label>
        <input name="tname" type="text" id="tname" class="opt_input" value=""/>
        <input name="tid" type="hidden" value="<%=request.getParameter("tid") %>" />
      </p>
      <input type="button" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<%@include file="console_element/bottom.txt" %>
</body>
</html>
