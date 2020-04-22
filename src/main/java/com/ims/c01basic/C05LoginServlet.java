package com.ims.c01basic;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class C05LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            if (userName.equals("gaoxu") && password.equals("123")) {
                HttpSession session = request.getSession();
                session.setAttribute("message", "登陆成功！");
                PrintWriter out = response.getWriter();
                out.println(1111);
                response.sendRedirect("cc01basic/c05servlet/target.jsp");
            } else {
                request.setAttribute("message", "用户名或密码错误！");
                PrintWriter out = response.getWriter();
                out.println(1111);
                request.getRequestDispatcher("c01basic/c05servlet/target.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
