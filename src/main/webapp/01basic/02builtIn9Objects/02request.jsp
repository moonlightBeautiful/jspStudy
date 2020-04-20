<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request对象</title>
</head>
<body>
<%
    /*1.获取request对象的所有参数*/
    Enumeration enu = request.getParameterNames();
    while (enu.hasMoreElements()) {
        String paraName = (String) enu.nextElement();
        System.out.println(paraName + ": " + request.getParameter(paraName));
    }
%>
</body>
</html>
