# jspservlet
1.hello
    1.简介：
        java的动态网页技术（B/S架构）
    2.tomcat
        web服务器，下载，解压就可以用。安装版一路默认。
        webapp目录，程序运行目录，把war包放到此目录下，tomcat运行后会自动解压war包。jsp被编译后产生的class文件到work目录中。
    3.基本语法
        1.page指令： 
            <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
                language：定义jsp要使用的脚本语言。这里只能是java。
                pageEncoding：编译jsp页面使用的编码。
                contentType：响应页面的mime类型和页面内容编码
                JSP要经过两次的“编码”和三个阶段：
                 第一阶段：首先用pageEncoding编码读取JSP文件，然后使用UTF-8编码将JSP文件编译成.java文件。
                 第二阶段：首先用UTF-8编码读取.java文件，然后使用UTF-8编码将.java文件编译成.class文件。
                 第三阶段：最后由Tomca以contentType编码将.class文件的内容响应到客户端。
        2.scriptlet标签：
            在页面潜入java代码
            <%! %>：定义全部，变量、方法和类。
            <% %>：定义局部，变量、java执行语句。
            <%= %>：输出一个局部或者全局变量 或者 内容
        3.注释
            <!-- html注释  -->：html注释， 客户端右键看源码可见
            <%-- 你好  --%>：jsp注释，客户端右键看源码不可见
            scriptlet标签中使用java注释：客户端右键看源码不可见
        4.包含文件指命令
            静态包含：先包含，再编译。<%@ include file="" %> 两个文件中不能有相同的变量
            动态包含：先编译，再包含。<%@ include page="" %> 两个文件中能有相同的变量
                以后选择动态包含
        5.跳转指令
            内部跳转，可以携带参数。浏览器url不变。
            <jsp:forward page="target.jsp">
                <jsp:param value="java1234" name="userName"/>
                <jsp:param value="123456" name="password"/>
            </jsp:forward>
            