<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie操作</title>
</head>
<body>
<%
    String userName = null;
    String pwd = null;
    Cookie[] cookies = request.getCookies();
    for (int i = 0; cookies != null && i < cookies.length; i++) {
        if (cookies[i].getName().equals("userNameAndPwd")) {
            userName = cookies[i].getValue().split("-")[0];
            pwd = cookies[i].getValue().split("-")[1];
        }
    }
    System.out.println(userName);
    System.out.println(pwd);
%>
</body>
</html>
