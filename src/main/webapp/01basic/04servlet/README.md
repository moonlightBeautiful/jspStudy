# servlet
简介
    服务器端小程序
使用
    1.类继承HttpServlet，重写父类doGet和doPost方法
    2.web.xml配置请求
    3.浏览器地址栏请求web.xml配置的请求
生命周期
    加载-->实例化-->服务-->销毁
        加载：服务器启动时，会自动对Servlet类进行加载。
        实例化：init()	 用户请求到这个servlet时，实例化一个Servlet对象，只执行一次。
        服务：service()	 用户请求到这个servlet时，执行doPost或者doGet方法
        销毁：destroy()	 长时间不用，服务器会自动销毁，或者关闭服务器。
servlet中获取session和application
    session：
        request.getSession
    application：
        this.getServletContext
servlet转发和重定向
    转发：
        服务器内部，浏览器地址栏不改变，request数据不丢失。
        request.getRequestDispacher("地址").forward(request,response)
    重定向：
        服务器外部，浏览器地址栏改变，request数据丢失。
        response.sendRedirect("地址)
过滤器filter：过滤用户的请求和响应，来回2次。
    1.过滤器类要 implement Filter接口
    2.要实现doFilter(ServletRequest rq，ServletResponse rs，FilterChain f)方法
          ServletRequest rq，ServletResponse rs  需要转换成HttpServletRequest和 HttpServletResponse 类型。
          f.doFilter(rq，rs)：传递到下一个过滤器,如果没有过滤器了则执行请求的Servlet
          note:
              Servlet中转发的话：下一个请求和上一个请求是同一个，所以不会再次过滤。
              Servlet中重定向的话：则会再从新过滤。
    3.在web.xml中配置 filter过滤器
        <filter>
            <filter-name>自己取名字</filter-name>
            <filter-class>filter类的路径</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>自己取名字</filter-name>
            <url-pattern>/*  (代表所有的请求)</url-pattern>
        <filter-mapping>
监听器listener：监听web事件，如 request、session、application添加或者删除数据	
    1.监听器类要 implement Http(Request/Session/Appolication)AttributeListener接口
    2.要实现3个方法
         attributeAdded(HttpSessionBindingEvent对象)		//添加时
         attributeRemoved(HttpSessionBindingEvent对象)	//移除时
         attributeReplaced(HttpSessionBindingEvent对象)	//替换时
         其中HttpSessionBindingEvent对象的方法：
            httpSessionBindingEvent对象.getName()	//触发事件时的属性名
            httpSessionBindingEvent对象.getValue()	//触发事件时的属性的值
    3.在web.xml中配置 listener监听器
        <listener>
            <listener-class>
            listener类的路径
            </listener-class>
        </listener>
