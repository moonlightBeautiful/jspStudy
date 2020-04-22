<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("session中的属性值：" + pageContext.getSession().getAttribute("name") + "<br/>");
%>

</body>
</html>
