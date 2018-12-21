<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="cn.jbit.news.bean.Topic" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
	List<Topic> li=(List<Topic>)session.getAttribute("topic");
	if(li!=null){
		%>
		<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;当前用户:<%=session.getAttribute("user").toString() %></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.txt" %>
  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}	
	</script>
    <ul class="classlist">
		<%
		for(Topic list : li){
			%>
				<li><%=list.getTname() %>&nbsp;&nbsp;<a href="topic_modify.jsp?tid=<%=list.getTid() %>">修改</a>&nbsp;&nbsp;<a href="../topic?toptype=delete&tid=<%=list.getTid() %>">删除</a></li>
			<%
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
		<%
	}
	 %>
