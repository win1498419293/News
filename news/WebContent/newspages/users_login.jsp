<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cn.jbit.news.bean.News_user"%>
<%@page import="java.util.List"%>
<script type="text/javascript" lang="javascript" src="../js/jquery-3.1.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		$("#ye").blur(function(){
		index=$("#ye option:selected").val();
		var	ind=parseInt(index);
		$(window).attr("location","../pag?type=paging&index="+ind);
	});
		$("#txt").blur(function(){
			index=$("#txt").val();
			var ind=parseInt(index);
			if(ind<${cun}){
				$(window).attr("location","../pag?type=paging&index="+ind);
			}else{
				$("#txt").val("超出页数");
				$(window).attr("location","../pag?type=paging&index="+${cun});
			}
			
		});
	});
</script>
	
</script>
<html>
<head>
<style type="text/css">
	#opt_area a{text-decoration:none; font-size:12px; color:#000;}
	#opt_area ul{list-style:none; clear:both;}
	#opt_area li{ float:left; width:100px; text-align:center; line-height:30px;}
</style>
<title>新闻系统</title>
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
  <%
  		
  		List<News_user> list = (List<News_user>)session.getAttribute("ulist");
  		Integer index = (Integer)session.getAttribute("index");
  		Integer cun= (Integer)session.getAttribute("cun");
  %>
  <div id="opt_area">
    <h1 id="opt_type"> 注册用户： </h1>
      <form action="" method="">
          <ul>
              <li>编号</li>
              <li>姓名</li>
              <li>密码</li>
              <li>邮箱:</li>
              <li>用户类型</li>
          </ul>
          <%
          	if(list!=null){
          		for(News_user li : list){
          			%>
          			  <ul>
			              <li><%=li.getId() %></li>
			              <li><%=li.getUserName() %></li>
			              <li><%=li.getPassword() %></li>
			              <li><%=li.getEmail() %></li>
			              <li><%=li.getUserType() %></li>
			          </ul>
          			<%
          		}
          	}
          
          %>
         
		  <!-- 分页业务 -->
          <ul>
          	<li><a href="../pag?type=paging&index=<%=1 %>">首页</a></li>
            <li><a href="../pag?type=paging&index=<%=index==1?1:index-1 %>">上一页</a></li>
            <li><a href="../pag?type=paging&index=<%=index==cun?cun:index+1 %>">下一页</a></li>
            <li><a href="../pag?type=paging&index=<%=cun%>">尾页</a></li>
          	<li>  
        <c:set var="i" value="1"/>
          	<select id="ye" name="ye">
          	<c:forEach var="l" begin="1"  end="${cun}">
            <option value="${l}">${l}</option>  
          	</c:forEach>
          		</select>
          	</li>
          	<li><input type="text" id="txt" placeholder="请输入跳转页码"> <li>
          </ul>
      </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
