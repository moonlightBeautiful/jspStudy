<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.ims.c01basic.C04Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>不使用usebean实例化类</title>
</head>
<body>
<%
    C04Student student = new C04Student();
    student.setName("王二小");
    student.setAge(12);
%>
<h1>姓名：<%=student.getName() %>
</h1>
<h1>年龄：<%=student.getAge() %>
</h1>
</body>
</html>