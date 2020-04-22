<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象</title>
</head>
<body>
<%
    pageContext.getOut().print("你好");
%>
<p>pageContext代表当前页面的上下文对象，可以获得其他的内置对象</p>
</body>
</html>
