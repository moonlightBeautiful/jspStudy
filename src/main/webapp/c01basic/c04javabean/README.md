# jspservlet
简介
    就是在jsp页面使用model类的实例
创建
    <jsp:useBean id="student" scope="使用范围page，其实就是存到了对应的四大作用域中" class="类全路径com.java1234.model.Student"/>
设置属性值
    如果form请求数据到页面，页面自动匹配值
        form的key和实例属性名一致时：<jsp:setProperty property="*支持通配符" name="实例名student"/>
        form的key和实例属性名不一致时：<jsp:setProperty property="*支持通配符" name="实例名student" param="form的key"/>
    也自己设置值<jsp:setProperty property="*支持通配符" name="实例名student" value="自己设置值""/>
获取属性值
    和创建语法一样，如果存在则取出来，不存在则创建
    <jsp:useBean id="student" scope="使用范围page" class="类全路径com.java1234.model.Student"/>
建议：
    没见到用过，了解就好。