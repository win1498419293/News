
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.jbit.news.bean.News" %>
<%@ page import="cn.jbit.news.bean.Topic" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"></script>
<script type="text/javascript" lang="javascript" src="../js/jquery-3.1.1.min.js" ></script>
</head>
<body>
<div id="header">
  <div id="welcome">&quot;欢迎使用新闻管理系统！</div>
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
		List<News> list = (List<News>)session.getAttribute("unews");
		List<Topic> tp_List = (List<Topic>)session.getAttribute("topic");
		if(list!=null){
			for(News news : list){
				//变量
				String tname = null;
				for(Topic li : tp_List){
					if(news.getNtid()==li.getTid()){
						tname = li.getTname();
					}
				}
				%>
			  <div id="opt_area">
			    <h1 id="opt_type"> 修改新闻： </h1>
			    <form action="../newsServlte?data=update" method="post" enctype="multipart/form-data" >
					
			      <input type="hidden" name="nid" value="<%=news.getNid() %>" />
			      <p>
			        <label> 主题 </label>
			        <input name="ntid" type="text" disabled="disabled" value="<%=tname %>" class="opt_input" />
			      </p>
			      <p>
			        <label> 标题 </label>
			        <input name="ntitle" type="text" value="<%=news.getNtitle() %>" class="opt_input" />
			      </p>
			      <p>
			        <label> 作者 </label>
			        <input name="nauthor" type="text" value="<%=news.getNauthor() %>" class="opt_input" />
			      </p>
			      <p>
			        <label> 摘要 </label>
			        <textarea name="nsummary" cols="40" rows="3"><%=news.getNsummary() %></textarea>
			      </p>
			      <p>
			        <label> 内容 </label>
			        <textarea name="ncontent" cols="70" class="ckeditor" rows="10"><%=news.getNcontent() %></textarea>
			      </p>
			      <p>
			        <label> 上传图片 </label>
			        <input name="npicpath" type="file" class="opt_input" />
			      </p>
			      <input type="submit" value="更新" class="opt_sub" />
			      <input type="reset" value="重置" class="opt_sub" />
			    </form>
			  </div>
				<%
			}
		}
		
	 %>
	
</div>
<div id="footer">
  <%@include file="console_element/bottom.txt" %>
</div>
</body>
</html>
