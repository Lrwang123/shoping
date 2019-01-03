<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请求错误</title>
	<meta charset="UTF-8">
    <script type="text/javascript">
    	alert("${message}");
		window.history.back();
    </script>
  </head>
  
  <body>
  </body>
</html>
