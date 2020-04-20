package com.ims.c01basic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class C02RedirectServlet2 extends HttpServlet {

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
        request.setAttribute("requestKey", "requestֵ");
        HttpSession session = request.getSession();
        session.setAttribute("sessionKey", "sessionֵ");
        ServletContext application = this.getServletContext();
        application.setAttribute("applicationKey", "applicationֵ");
        response.sendRedirect("c04servlet/target.jsp");
    }


}
