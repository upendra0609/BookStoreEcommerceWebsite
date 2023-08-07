package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {


    public AdminLoginFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest =(HttpServletRequest) request;
		HttpServletResponse httpResponse =(HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
		boolean loggedIn =  session !=null && session.getAttribute("email")!=null;
		String loginURI = httpRequest.getContextPath() +"/admin/login";
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		
		boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		if(loggedIn && (loginPage || loginRequest)) {
			httpResponse.sendRedirect("./");
		}else if(loggedIn || loginRequest) {         //both condition will never be true because if both are true then if statement will be execute
			chain.doFilter(request, response);
		}else {
			httpRequest.getRequestDispatcher("login.jsp").forward(httpRequest, httpResponse);
		}
		
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
