<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>操作cookie</title>
    <%
        Cookie userNameAndPwd = new Cookie("userNameAndPwd", "gaoxu-123456");
        userNameAndPwd.setMaxAge(1 * 60 * 60 * 24 * 7); // cookie记录一个星期
        response.addCookie(userNameAndPwd);  // 保存cookie
        System.out.println("设置Cookie成功");
        response.sendRedirect("./06cookie.jsp");
    %>
</head>
<body>

</body>
</html>