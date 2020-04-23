# jspservlet
文件上传
    1.引入2个jar包 commons-io-2.4.jar和commons-fileupload-1.2.2.jar
    2.form enctype="multipart/form-data 
    3.servlet 接收文件 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = upload.parseRequest(request);
        item.isFormField() //是否普通字段
        InputStream in = item.getInputStream(); //文件字段获取输入流
    
文件上传功能有许多需要注意的小细节问题，以下列出的几点需要特别注意的
 　　1、为保证服务器安全，上传文件应该放在外界无法直接访问的目录下，比如放于WEB-INF目录下。
 　　2、为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名。
 　　3、为防止一个目录下面出现太多文件，要使用hash算法打散存储。
 　　4、要限制上传文件的最大值。
 　　5、要限制上传文件的类型，在收到上传文件名时，判断后缀名是否合法。

文件下载
    FileInputStream in = new FileInputStream(path + "\\" + fileName);
    response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(文件名, "UTF-8"));
    OutputStream out = response.getOutputStream();
    byte buffer[] = new byte[1024];
    int len = 0;
    //循环将输入流中的内容读取到缓冲区当中
    while ((len = in.read(buffer)) > 0) {
        //输出缓冲区的内容到浏览器，实现文件下载
        out.write(buffer, 0, len);
    }
    in.close();
    out.close();
    
    