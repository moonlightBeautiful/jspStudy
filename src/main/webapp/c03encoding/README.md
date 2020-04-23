jsp编码
   JSP要经过两次的“编码”和三个阶段：
   第一阶段：首先用pageEncoding编码读取JSP文件，然后把JSP文件翻译成UTF-8 JAVA文件。
   第二阶段：再把JAVA文件翻译成UTF-8 class文件，即二进制码。JVM运行class文件，产生UTF-8 响应数据。
   第三阶段：最后由Tomcat把 响应数据 翻译成 contentType响应数据 到客户端。  
URL
    URL由三部分组成： 
        ①第一部分是协议(或称为服务方式)。
        ②第二部分是存有该资源的主机IP地址(有时也包括端口号)。
        ③第三部分是主机资源的具体地址，如目录和文件名等。
        比如URL:http://www.123.com/123/index.html（唯一的文件）            
    网页通过浏览器向服务器提交数据编码和解码过程：
        HTTP协议只能传输ASCII码
        https://blog.csdn.net？msg=杭州     
        浏览器：
            1.第一步，如果是get请求，浏览器把请求参数拼接在地址后面，如果是post请求，则对请求参数编码
                https://blog.csdn.net？msg=杭州   
                post: 编码方式由浏览器决定：浏览器的编码在<meta http-equiv="Content-Type" content="text/html; charset=utf-8">指定          
            2.第二步，浏览器对url进行URL encode编码，
                https://blog.csdn.net？msg=%wde12
                URL encode编码只对ASCII以外的字符有效：先对中文进行编码，再转换成16进制字符，再每个字节前加上% 
            3.第三步，浏览器把编码后的url以iso-8859-1的编码方式转化为0101000101发往服务器
                0101000101
        服务器端:
            1.第一步，tomcat以iso-8859-1的编码方式解码
                https://blog.csdn.net？msg=%wde12
            2.第二步，用tomcat配置的解码方式再次解码
                https://blog.csdn.net？msg=杭州
                get：<Connector port="8080" URIEncoding="utf-8"/> 只对get请求有效,
                post：request.setCharacterEncoding(this.encoding)和Spring MVC 自带的字符编码过滤器只对post请求有效.		
                所以以开发时两个都要配置
编码知识：
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
        