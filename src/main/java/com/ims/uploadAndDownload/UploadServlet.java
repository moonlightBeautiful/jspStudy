package com.ims.uploadAndDownload;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class UploadServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
        //webӦ�õ�Ӳ��·��Ϊ���
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {
            //��������Ŀ¼
            saveFile.mkdir();
        }
        //�ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //������ʱĿ¼
            tmpFile.mkdir();
        }

        //��Ϣ��ʾ
        String message = "";
        try {
            //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
            //1������һ��DiskFileItemFactory����
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //      ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
            factory.setSizeThreshold(1024 * 100);//���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
            //      �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
            factory.setRepository(tmpFile);
            //2������һ���ļ��ϴ�������
            ServletFileUpload upload = new ServletFileUpload(factory);
            //      �����ļ��ϴ�����
            upload.setProgressListener(new ProgressListener() {
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���" + pBytesRead);
                    /**
                     * �ļ���СΪ��14608,��ǰ�Ѵ���4096
                     �ļ���СΪ��14608,��ǰ�Ѵ���7367
                     �ļ���СΪ��14608,��ǰ�Ѵ���11419
                     �ļ���СΪ��14608,��ǰ�Ѵ���14608
                     */
                }
            });
            //      ����ϴ��ļ�������������
            upload.setHeaderEncoding("UTF-8");
            //      �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
            upload.setFileSizeMax(1024 * 1024);
            //      �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
            upload.setSizeMax(1024 * 1024 * 10);
            //3���ж��ύ�����������Ƿ����ϴ���������
            if (!ServletFileUpload.isMultipartContent(request)) {
                //���մ�ͳ��ʽ��ȡ����
                return;
            }
            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������

            //��ʽ2 �����ļ� ��ʽ
            /*FileItemIterator fileItemIterator = upload.getItemIterator(request);
            while(fileItemIterator.hasNext()) {
                FileItemStream fileItemStream = fileItemIterator.next();
                InputStream stream = fileItemStream.openStream();
                String fileName;
                String fileValue;
                if (fileItemStream.isFormField()) {
                    fileName = fileItemStream.getFieldName();
                    fileValue = Streams.asString(stream, "utf-8");
                } else  {
                    fileName = fileItemStream.getFieldName();
                    fileName = fileItemStream.getName();
                    OutputStream fileOutputStream = new FileOutputStream(new File("c01basic:/"
                            + fileName));
                    IOUtils.copy(stream, fileOutputStream);
                    IOUtils.closeQuietly(stream);
                    IOUtils.closeQuietly(fileOutputStream);
                }
            }*/

            //��ʽ1 ��ͳ��ʽ ��ʱ�ļ�+�����ļ�
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //���fileitem�з�װ������ͨ�����������
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //�����ͨ����������ݵ�������������
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println("��ͨ�" + name + "=" + value);
                } else {//���fileitem�з�װ�����ϴ��ļ�
                    //�õ��ϴ����ļ����ƣ�
                    String filename = item.getName();
                    //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c01basic:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //�õ��ϴ��ļ�����չ��,�����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
                    //String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
                    //��ȡitem�е��ϴ��ļ���������
                    InputStream in = item.getInputStream();
                    //�õ��ļ����������
                    String saveFilename = UUID.randomUUID().toString() + "_" + filename;
                    //�õ��ļ�����Ŀ¼�����磺upload\2\3  upload\3\5
                    int hashcode = filename.hashCode();
                    int dir1 = hashcode & 0xf;  //0--15
                    int dir2 = (hashcode & 0xf0) >> 4;  //0-15
                    String realSavePath = savePath + "\\" + dir1 + "\\" + dir2;  //
                    File realSaveFile = new File(realSavePath);
                    if (!realSaveFile.exists()) {
                        realSaveFile.mkdirs();
                    }
                    //����һ���ļ������
                    FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                    //����һ��������
                    byte buffer[] = new byte[1024];
                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
                    int len = 0;
                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
                    while ((len = in.read(buffer)) > 0) {
                        //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
                        out.write(buffer, 0, len);
                    }
                    //�ر�������
                    in.close();
                    //�ر������
                    out.close();
                     /*IOUtils.copy(in, out);
                    IOUtils.closeQuietly(in);
                    IOUtils.closeQuietly(out);*/
                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
                    item.delete();
                    message = "�ļ��ϴ��ɹ���";
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "�����ļ��������ֵ������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            message = "�ļ��ϴ�ʧ�ܣ�";
            e.printStackTrace();
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/02uploadAndDownload/message.jsp").forward(request, response);
    }

}
