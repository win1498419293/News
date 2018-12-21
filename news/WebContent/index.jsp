﻿<%@page import="cn.jbit.news.bean.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script language="javascript">
	$(function(){
			var login_username = $("#uname");
			login_username.focus();	
			//点击提交
			$(".login_sub").click(function(){
				var login_username = $("#uname").val();
				var login_password = $("#upwd").val();
				if(login_username == ""){
					alert("用户名不能为空！请重新填入！");
					login_username.focus();	
					return false;
				}else if(login_password == ""){
					alert("密码不能为空！请重新填入！");
					login_password.focus();
					return false;
				}
				//提交
				$("#myform").submit();
			});
	});
</script>
</head>
<body>
		<div id="header">
  <div id="top_login">
    <form action="login?type=login" method="post" id="myform">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="" class="login_input" />
      <input type="button" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      <c:if test="${news ne null}">
      	<c:set var="i" value="0" />
      	<c:forEach var="li" items="${news }">
      		<c:if test="${li.ntid eq 1 }">
      			<c:set var="i" value="${ i+1 }" />
      			<c:if test="${ i<= 5 }">
      				<li><a href="Comment?comtype=query&id=${li.nid}"><b>${li.ntitle}</b></a></li>
      			</c:if>
      		</c:if>
      	</c:forEach>
      </c:if>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
        <c:if test="${news ne null}">
      	<c:set var="i" value="0" />
      	<c:forEach var="li" items="${news }">
      		<c:if test="${li.ntid eq 2 }">
      			<c:set var="i" value="${ i+1 }" />
      			<c:if test="${ i<= 5 }">
      				<li><a href="Comment?comtype=query&id=${li.nid}"><b>${li.ntitle}</b></a></li>
      			</c:if>
      		</c:if>
      	</c:forEach>
      </c:if>
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <c:if test="${news ne null}">
      	<c:set var="i" value="0" />
      	<c:forEach var="li" items="${news }">
      		<c:if test="${li.ntid eq 5 }">
      			<c:set var="i" value="${ i+1 }" />
      			<c:if test="${ i<= 5 }">
      				<li><a href="Comment?comtype=query&id=${li.nid}"><b>${li.ntitle}</b></a></li>
      			</c:if>
      		</c:if>
      	</c:forEach>
      </c:if>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'> <a href='#'><b> 国内 </b></a> <a href='#'><b> 国际 </b></a> <a href='#'><b> 军事 </b></a> <a href='#'><b> 体育 </b></a> <a href='#'><b> 娱乐 </b></a> <a href='#'><b> 社会 </b></a> <a href='#'><b> 财经 </b></a> <a href='#'><b> 科技 </b></a> <a href='#'><b> 健康 </b></a> <a href='#'><b> 汽车 </b></a> <a href='#'><b> 教育 </b></a> </li>
        <li id='class_month'> <a href='#'><b> 房产 </b></a> <a href='#'><b> 家居 </b></a> <a href='#'><b> 旅游 </b></a> <a href='#'><b> 文化 </b></a> <a href='#'><b> 其他 </b></a> </li>
      </ul>
      <ul class="classlist">
        <li><a href='newspages/news_read.jsp'> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 </a><span> 2013-06-06 01:03:51.0 </span></li>
        <li><a href='#'> 习近平在墨国会发表演讲:朋友要老 好酒要陈 </a><span> 2013-06-06 01:03:19.0 </span></li>
        <li><a href='#'> 《致命黑兰》佐伊坐拥7种武器 暴力登陆全国院线 </a><span> 2013-06-06 01:02:56.0 </span></li>
        <li><a href='#'> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a><span> 2013-06-06 01:02:17.0 </span></li>
        <li><a href='#'> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战
 </a><span> 2013-06-06 01:01:47.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> 高中女生邀帕森斯参加舞会 高富帅租豪车护花 </a><span> 2013-06-06 01:00:37.0 </span></li>
        <li><a href='#'> 商贸联委会在杭州开会 中美对贸易争端态度低调 </a><span> 2013-06-06 01:00:11.0 </span></li>
        <li><a href='#'> 《新恋爱时代》登东方卫视 《非诚》元素遭删除 </a><span> 2013-06-06 12:59:45.0 </span></li>
        <li><a href='#'> 伊朗称放弃美元作为外储地位 人民币或上位 </a><span> 2013-06-06 12:58:42.0 </span></li>
        <li><a href='#'> “持械抢劫，当场击毙” 浙江永康现超雷人标语 </a><span> 2013-06-06 12:58:20.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> 男子用微信“摇一摇”寻找女网友 见面劫财又劫色 </a><span> 2013-06-06 12:57:18.0 </span></li>
        <li><a href='#'> 俄数百所幼儿园和学校因流感停课 </a><span> 2013-06-06 12:56:51.0 </span></li>
        <li><a href='#'> 喀布尔市中心传出爆炸和枪声 目前原因不明 </a><span> 2013-06-06 12:56:24.0 </span></li>
        <li><a href='#'> 国台办介绍大陆高校加大对台招生力度情况 </a><span> 2013-06-06 12:55:07.0 </span></li>
        <li><a href='#'> 国台办将授权福建等六省市部分赴台管理审批权 </a><span> 2013-06-06 12:54:12.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> 人保部将首次就同工同酬做出规定 </a><span> 2013-06-06 11:00:45.0 </span></li>
        <li><a href='#'> 重庆警方否认被围殴致死吸毒者曾针刺民众 </a><span> 2013-06-06 11:00:25.0 </span></li>
        <li><a href='#'> 美国一名外交官辞职抗议美对阿富汗政策 </a><span> 2013-06-06 11:00:02.0 </span></li>
        <li><a href='#'> 埃及交通部长因致18死火车相撞事故辞职 </a><span> 2013-06-06 10:59:38.0 </span></li>
        <li><a href='#'> 无姚时代如何关注内线比拼 新赛季中锋PK五岳崛起 </a><span> 2013-06-06 10:59:07.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a><span> 2013-06-06 10:58:36.0 </span></li>
        <li><a href='#'> 时过境迁火箭优势变劣势 对抗双塔阿帅只一计可施 </a><span> 2013-06-06 10:58:11.0 </span></li>
        <li><a href='#'> 美男篮邀请考辛斯参加训练营 厄文小乔丹同获邀 </a><span> 2013-06-06 10:57:49.0 </span></li>
        <li><a href='#'> 美媒体称小布乃火箭新核心 一大缺陷令阿帅很担心 </a><span> 2013-06-06 10:57:11.0 </span></li>
        <li><a href='#'> 高中女生邀帕森斯参加舞会 高富帅租豪车护花 </a><span> 2013-06-06 10:56:43.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> 8名美军士兵在阿富汗遭路边炸弹袭击身亡 </a><span> 2013-06-06 10:55:38.0 </span></li>
        <li><a href='#'> 与基地有关组织宣称对巴格达连环爆炸负责 </a><span> 2013-06-06 10:55:14.0 </span></li>
        <li><a href='#'> 我军少将：中印两国不会因领土争端大打出手 </a><span> 2013-06-06 10:54:54.0 </span></li>
        <p align="right"> 当前页数:[1/2]&nbsp; <a href="#">下一页</a> <a href="#">末页</a> </p>
      </ul>
    </div>
    <%@ include file="index-elements/index_rightbar.txt" %>
  </div>
</div>
  <%@ include file="index-elements/index_bottom.txt"%>
</body>
</html>

