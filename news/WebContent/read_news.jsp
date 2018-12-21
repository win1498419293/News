<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function checkComment(){
		var cauthor = document.getElementById("cauthor");
		var content = document.getElementById("ccontent");
		if(cauthor.value == ""){
			alert("用户名不能为空！！");
			return false;
		}else if(content.value == ""){
			alert("评论内容不能为空！！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div id="container">
  <%@ include file="../index-elements/index_sidebar.jsp"%>
  <c:forEach var="li" items="${newsid}">
  <div class="main" style="position:relative;">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content" style="position:absolute;left:50px;">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${li.ntitle}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
           
          <tr>
            <td align="center">作者：${com.cauth}
             </a></td>
            <td align="left">发布时间：${li.ncreatedate}</td>
          </tr>          
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2"></td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            <c:forEach var="com" items="${commid}">
            <tr>
            <td>${com.cid}</td>
            <td>${com.cconent}</td>
            <td >${com.cdate}</td>
            <td >${com.cip}</td>
            <td >${com.cauth}</td>
          </tr>
          </c:forEach>
          </tr>
        </table>
        
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
        <c:if test="">
        	<td colspan="6"> 暂无评论！ </td>
	          <tr>
	            <td colspan="6"><hr />
	            </td>
	          </tr>
        </c:if>        
        <c:if test="">        
        	<c:forEach var="comment" items="">        	
        		<tr>
				    <td> 留言人：<c:out value="${commid.cauth}" /> </td>
				    <td></td>
					<td> IP：<c:out value="${commid.cip}" /> </td>
					<td></td>
					<td> 留言时间： <c:out value="${commid.cdata}" /> </td>
					<td></td>
				</tr>
				<tr>
					<td colspan="6"></td>
				</tr>
				<tr>
					<td colspan="6"><hr />
					</td>
				</tr>       	
       		</c:forEach>       	
       	 </c:if>  
        </table>
      </ul>
      <ul class="classlist">
        <form action="Comment?comtype=addComment&nid=${li.nid}"method="post" onSubmit="return checkComment()">
          <table width="80%" align="center">
            <tr>
              <td> 评 论  <input type="text" id="utxt" name="utxt" value=""/></td>
            </tr>
            <tr>
              <td> 用户名：<input type="text" id="uname" name="uname" value=""/> </td>
              <td>
              	<c:if test="">	             
	              <input id="cauthor" type="text" name="cauthor" value="" readonly="readonly" style="border:0px;"/>
	            </c:if> 
	            <c:if test="">
	              <input type="text" id="cauthor" name="cauthor" value="这家伙很懒什么也没留下"/>
	            </c:if>
                IP：
                <input type="text" name="cip" id="cip" value=""  style="border:0px;"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" id="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
        </form>
      </ul>
    </div>
  </div>
</div>

<%@include file="../index-elements/index_bottom.txt"%>
</body>
</html>
</c:forEach>