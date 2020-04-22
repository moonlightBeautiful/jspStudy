<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("application中的属性值：" + pageContext.getServletContext().getAttribute("name3") + "<br/>");
%>

</body>
</html>
