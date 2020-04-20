<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name0", "pageInfo");
    request.setAttribute("name1", "requestInfo");
    session.setAttribute("name2", "sessionInfo");
    application.setAttribute("name3", "applicationInfo");

    out.println("使用pageContext<br/>");
    out.println("pageContext中的属性值：" + pageContext.getAttribute("name0") + "<br/>");
    out.println("request中的属性值：" + pageContext.getRequest().getAttribute("name1") + "<br/>");
    out.println("session中的属性值：" + pageContext.getSession().getAttribute("name2") + "<br/>");
    out.println("application中的属性值：" + pageContext.getServletContext().getAttribute("name3") + "<br/>");
%>

</body>
</html>
