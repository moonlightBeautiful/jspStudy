关于编码
    1.tomcat组件
        Tomcat的两个核心组件：Connector和Container
        1.Connector组件
            在某个指定的端口上监听HTTP请求或者WebServer的请求，创建一个Request和一个Response对象分别用于和客户端交换数据，
            然后会产生一个线程来处理这个请求并把产生的Request和Response对象传给Engine，从Engine中获得响应并返回给客户端。
        2.Container组件
            它由四个自容器组件构成，分别是Engine、Host、Context、Wrapper。
        3.其他组件
            Tomcat中还有其他重要的组件，如安全组件security、logger日志组件、session、mbeans、naming等其他组件。
            这些组件共同为Connector和Container提供必要的服务。
    2.tomcat处理一个HTTP请求的过程
        1.用户在浏览器中输入网址localhost:8080/test/index.jsp，请求被发送到本机端口8080，被在那里监听的Coyote HTTP/1.1 Connector获得；
        2.Connector把该请求交给它所在的Service的Engine（Container）来处理，并等待Engine的回应；
        3.Engine获得请求localhost/test/index.jsp，匹配所有的虚拟主机Host；
        4.Engine匹配到名为localhost的Host（即使匹配不到也把请求交给该Host处理，因为该Host被定义为该Engine的默认主机），名为localhost的Host获得请求/test/index.jsp，匹配它所拥有的所有Context。Host匹配到路径为/test的Context（如果匹配不到就把该请求交给路径名为“ ”的Context去处理）；
        5.path=“/test”的Context获得请求/index.jsp，在它的mapping table中寻找出对应的Servlet。Context匹配到URL Pattern为*.jsp的Servlet，对应于JspServlet类；
        6.构造HttpServletRequest对象和HttpServletResponse对象，作为参数调用JspServlet的doGet()或doPost(),执行业务逻辑、数据存储等；
        7.Context把执行完之后的HttpServletResponse对象返回给Host；
        8.Host把HttpServletResponse对象返回给Engine；
        9.Engine把HttpServletResponse对象返回Connector；
        10.Connector把HttpServletResponse对象返回给客户Browser。
        简单来说：
            1.客户端请求被监听到，被发送到Connector；
            2.Connector把该请求交给Container，执行对应的servlet，把执行完之后的请求和响应交给Connector；
            3.Connector把请求和响应返回给客户端。
    3.URL和URI
        URI：
            通一资源标志符(Uniform Resource Identifier)，表示的是web上每一种可用的资源，如 HTML文档、图像、视频片段、程序等都由一个URI进行定位的。
        URI通常由三部分组成：
            ①访问资源的命名机制；
            ②存放资源的主机名；
            ③资源自身的名称。
        URI举例
            如：https://blog.csdn.net/qq_32595453/article/details/79516787
            我们可以这样解释它：
                ①这是一个可以通过https协议访问的资源，
                ②位于主机 blog.csdn.net上，
                ③通过“/qq_32595453/article/details/79516787”可以对该资源进行唯一标识（注意，这个不一定是完整的路径）
            注意：以上三点只不过是对实例的解释，以上三点并不是URI的必要条件，URI只是一种概念，怎样实现无所谓，只要它唯一标识一个资源就可以了。
        URL:
            统一资源定位符(Uniform Resource Locator)，是URI的一个子集，是URI概念的一种实现方式。通俗地说，URL是Internet上描述信息资源的字符串，主要用在各种WWW客户程序和服务器程序上。
        URL的格式由三部分组成： 
            ①第一部分是协议(或称为服务方式)。
            ②第二部分是存有该资源的主机IP地址(有时也包括端口号)。
            ③第三部分是主机资源的具体地址，如目录和文件名等。
        URI和URL之间的区别
            URI是粗框架，URL是详细定位。。。
            比如URI：http://www.123.com/123/，该目录下可能有index.html和index.htm（两个文件）。。。
            比如URL:http://www.123.com/123/index.html（唯一的文件）            
    4.关于编码
        1.浏览器第一次访问jsp页面的编码：
            JSP要经过两次的“编码”和三个阶段：
            第一阶段：首先用pageEncoding编码读取JSP文件，然后把JSP文件翻译成UTF-8 JAVA文件。
            第二阶段：再把JAVA文件翻译成UTF-8 class文件，即二进制码。JVM运行class文件，产生UTF-8 响应数据。
            第三阶段：最后由Tomcat把 响应数据 翻译成 contentType响应数据 到客户端。 
        2.浏览器和服务器的编码和解码
            网页向服务器提交数据编码和解码过程：
                浏览器讲请求中的非ASCII字符encode编码成 "%XX" 的格式数据发送给服务器。
                服务器接收到"%XX"格式的数据后，解码成字符串。
            tomcat8以后默认编码格式是utf-8；7之前的都是iso8859-1。
            乱码解决：后台编码与前台浏览器编码方式同步一致。
                1.post
                    解决：方法最开始使用request.setCharacterEncoding("指定编码（与浏览器同步）")
                2.get，提示：默认request设置编码无效。
                    解决：                        
                        更改Tomact的conf目录下的server.xml文件
                        <Connector port="8080"  protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8" />

                

            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    1.位（bit）：是计算机内部 数据储存 的最小单位，11001100是一个八位二进制数。每个二进制数字0或者1就是1个位；
    2.字节（byte）：是计算机中 数据处理 的基本单位，8个位构成一个字节。习惯上用大写  B  来表示,1B（byte,字节）= 8bit（位）
    3.字符：是指计算机中使用的字母、数字、字和符号
         a、A、中、+、*、の......均表示一个字符；
         一般 utf-8 编码下，一个汉字 字符 占用 3 个 字节；
         一般 gbk 编码下，一个汉字  字符  占用 2 个 字节；
    4.字符集
        即各种各个字符的集合，也就是说哪些汉字，字母（A、b、c）和符号（空格、引号..）会被收入标准中；
    5.编码：
        规定每个“字符”分别用几个字节、什么样的字节来存储，这个规定就叫做“编码”。
        （其实际是对字符集中字符进行编码，即：每个字符用二进制数010101010在计算中表示存储）；
        通俗的说：编码就是按照规则对字符进行翻译成对应的二进制数，在计算器中运行存储，用户看的时候（比如浏览器），在用对应的编码解析出来用户能看懂的；
        