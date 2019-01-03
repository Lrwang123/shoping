<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>其他错误</title>
    
	<meta charset="UTF-8">
	<script type="text/javascript">
		alert("404:请求的页面不存在！");
		window.history.back();
	</script>
  </head>
  
  <body>
    
  </body>
</html>
