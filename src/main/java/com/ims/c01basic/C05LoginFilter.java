package com.ims.c01basic;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class C05LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpSession session=request.getSession();
		Object o=session.getAttribute("currentUser");
		String path=request.getServletPath();
		if(o==null&&path.indexOf("login")<0){
			request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
		}else{
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
