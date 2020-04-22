<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page errorPage="c09error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>可能发生异常的页面</title>
</head>
<body>
<%
    int a = 1;
    int b = 0;
    out.println(a / b);
%>
<p>
    可能发生异常页面，发生异常时自动转发到异常处理界面， page errorPage="异常处理界面.jsp"
</p>
</body>
</html>