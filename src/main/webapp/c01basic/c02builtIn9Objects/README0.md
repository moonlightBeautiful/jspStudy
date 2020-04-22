# jspservlet
简介
    jsp为用户提供了9大内置对象和4大作用域，供用户使用。
9大内置对象：
    1.pageContext
        pageContext代表当前页面的上下文对象，可以获得其他的内置对象
    2.request
         用户的一次请求，会默认携带一些头信息。
         通过requet对象获取头信息
         Enumeration enu = request.getHeaderNames();
         while (enu.hasMoreElements()) {
             String headerName = (String) enu.nextElement();
             String headerValue = request.getHeader(headerName);
         }
    3.response
        响应客户端请求，向浏览器输出信息。
        功能：
            1.刷新页面
            2.重定向
            3.存放cookie数据
    4.out，类是PrintWriter
            向客户端输出各种内容类型数据和管理服务器的输出缓冲区。
            jsp页面直接使用
            servlet中 response.getWriter
    5.session
    6.application
    7.config
        jsp容器tomcat启动初始化的数据，也就是web.xml请求上设置的参数。
    8.page 
        就当没有它就好
        page对象是当前页面转换后的Servlet类的实例。很少使用page对象，直接不要使用，就没见到过使用的。
    9.exception
        需要配合<%@ page errorPage="异常处理界面.jsp" %>和<%@ page isErrorPage="true" %>使用
        可能发生异常页面，发生异常时自动转发到异常处理界面，<%@ page errorPage="异常处理界面.jsp" %>
        异常处理界面，开启exception对象，<%@ page isErrorPage="true" %>
浏览器的cookie对象
    Cookie是List<键值对>