<%--
  Created by gaoxu.
  User: gaoxu
  Date: 2019/5/31 0031
  Time: 09:17
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>基础语法</title>
</head>
<%!
    String str = "全局变量";
%>
<%!
    public void fun1() {
        System.out.println("全局方法");
    }
%>
<%!
    class C {
        private int a;

        public void f() {
            System.out.println("全局类");
        }
    }
%>
<%
    int a = 1234;
    out.println("局部变量" + a);
    out.println("全局变量" + str);
%>
<body>
<%=a %>
<%=str %>
<br>
html注释， 客户端可见：
<!-- html注释  -->
<br>
jsp注释，客户端不可见:
<%-- 你好  --%>
<br>
java注释，客户端不可见:
<%
    //你好
    /**
     * 你好
     */
    /*
     你好
     */
%>
</body>
</html>
