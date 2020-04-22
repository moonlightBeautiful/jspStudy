1.URL和URI
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




网络标准RFC 1738做了硬性规定：URL只能使用英文字母、阿拉伯数字和某些标点符号，不能使用其他文字和符号。
比如，世界上有英文字母的网址"http://www.abc.com"，但是没有希腊字母的网址"http://www.aβγ.com"
如果URL中有其他文字符号，就必须编码后使用，
但RFC 1738没有规定具体的编码方法，而是交给应用程序（浏览器）自己决定。这导致"URL编码"成为了一个混乱的领域。
应用程序（浏览器）需要对除了ASCII字母、数字、标点符号"@ * _ + - . /"以外，对其他所有字符进行编码。
浏览器输入：
    http://zh.wikipedia.org/wiki/春节  在开发工具中得到  https://zh.wikipedia.org/wiki/%E6%98%A5%E8%8A%82
        "春"和"节"的utf-8编码分别是"E6 98 A5"和"E8 8A 82"。网址路径的编码，用的是utf-8编码。
    http://www.baidu.com/s?wd=春节    在开发工具中得到  https://www.baidu.com/s?wd=%E6%98%A5%E8%8A%82
       "春"和"节"的utf-8编码分别是"E6 98 A5"和"E8 8A 82"。查询字符串的编码，用的是utf-8编码。
在已打开的网页上，直接用Get或Post方法发出HTTP请求    
    这时的编码方法由网页的编码决定
在Ajax调用中
保证客户端只用一种编码方法向服务器发出请求
    使用Javascript先对URL编码，然后再向服务器提交，不要给浏览器插手的机会。 
    Javascript函数：utf-8形式   
        encodeURI()/decodeURI() 对整个URL进行编码
        encodeURIComponent decodeURIComponent  对URL的组成部分进行个别编码  
        "; / ? : @ & = + $ , #"，这些在encodeURI()中不被编码的符号，在encodeURIComponent()中统统会被编码。
  
    

     