<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>默认的取值的四种范围属性顺序：page > request > session > application</title>
</head>
<body>
<%
    pageContext.setAttribute("info1", "page范围的值");
    request.setAttribute("info1", "request范围的值");
    session.setAttribute("info1", "session范围的值");
    application.setAttribute("info1", "application范围的值");
%>
<h1>${info1 }</h1>
<br>
默认的取值的四种范围属性顺序：page > request > session > application
</body>
</html>