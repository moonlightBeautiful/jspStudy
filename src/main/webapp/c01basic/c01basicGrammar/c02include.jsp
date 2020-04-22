<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>动态和静态包含，我们要选择动态包含。</title>
</head>
<body>
<%-- <h1>静态包含</h1>
<%@ include file="common/head.html" %>
<p>静态包含，先把head.html和footer.jsp包含进来，再编译，产生一个class文件。有1个class文件。</p>
<%@ include file="common/footer.jsp" %> --%>


<h1>动态包含</h1>
<jsp:include page="c02head.html"/>
<p>动态包含，先把jsp编译成class文件，然后包含进来，再编译一次。有多个class+1个class文件。</p>
<jsp:include page="c02footer.jsp"/>
</body>
</html>
