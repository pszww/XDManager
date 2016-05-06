<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=uft-8"> 
    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="resources/extjs/resources/css/ext-all-neptune.css" rel="stylesheet" type="text/css" />
	 <script type ="resources/extjs/ext-lang-zh_CN.js" ></script>
     <title>查询</title>
	 <script type="text/javascript" src="resources/extjs/ext-all-dev.js"></script>
     <script type="text/javascript" src="find.js" charset="utf-8"></script> 

    <div id="toolbar"></div>
    <div id="grid"></div>
  </body>
</html>
