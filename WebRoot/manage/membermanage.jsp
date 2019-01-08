<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>51商城――后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../manage/CSS/style.css" rel="stylesheet">
</head>

<body>  
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="right">&nbsp;</td>
        <td height="10" colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" align="right">&nbsp;</td>
        <td width="10" background="../manage/images/manage_leftTitle_left.GIF">&nbsp;</td>
        <td width="1089" align="center" background="../manage/images/manage_leftTitle_mid.GIF" class="word_white"><b>会员列表</b></td>
        <td width="10" background="../manage/images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
<table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="13" align="center">&nbsp;</td>
            </tr>
      </table>
            <table width="96%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr>
                <td width="14%" height="27" align="center">用户名</td>
                <td width="14%" align="center">真实姓名</td>
                <td width="14%" align="center">电话</td>
                <td width="26%" align="center">Email</td>
                <td width="10%" align="center">销费额</td>
                <%--<td width="11%" align="center">冻结/解冻</td>
              --%></tr>
			<c:forEach items="${paper.list }" var="user">
              <tr style="padding:5px;">
                <td height="24" align="center"><a href="user_detail.php?ID=${user.userId }">${user.username }</a>&nbsp;</td>
                <td align="center">${user.name }&nbsp;</td>
                <td align="center">${user.tel }&nbsp;</td>
                <td align="center">${user.email }&nbsp;</td>
                <td align="center">${user.grade }</td>
              </tr>
			</c:forEach>
      </table>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="27" align="right">当前页数：[${paper.pageNumber }/${paper.pages }]&nbsp;
		<c:if test="${!paper.firstPage }">
			<a href="user_list.php?Page=1">第一页</a>
			<a href="user_list.php?Page=${paper.pageNumber-1 }">上一页</a>
		</c:if>
		<c:if test="${!paper.lastPage }">
			<a href="user_list.php?Page=${paper.pageNumber+1 }">下一页</a>
			<a href="user_list.php?Page=${paper.pages }">最后一页&nbsp;</a>
		</c:if>
	</td>
  </tr>
</table>
	 <!----> 
</td>
	  
	      <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="199" valign="top" bgcolor="#FFFFFF"><jsp:include page="navigation.jsp"/></td>
      </tr>
    </table></td>	  
  </tr>
</table>
<jsp:include page="copyright.jsp"/>
</body>
</html>
