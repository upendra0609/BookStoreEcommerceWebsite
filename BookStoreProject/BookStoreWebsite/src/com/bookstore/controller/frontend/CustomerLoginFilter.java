package com.bookstore.controller.frontend;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class CustomerLoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public CustomerLoginFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		
	    
	    
	

		//redirecting to admin directory if admin wants to visit admin page 
		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		
		
		//for security purpose to hide frontend directory(if anyone wants to visit by entering url directly)
		if (path.startsWith("/frontend/")) {
			httpResponse.sendRedirect("../");
			return;
		}

		//if customer wants to see profile then checking whether customer is logged in or not
		if (!loggedIn && (path.startsWith("/view_profile") || path.startsWith("/edit_customer") || path.startsWith("/update_customer") || path.startsWith("/write_review") || path.startsWith("/view_cart") || path.startsWith("/add_to_cart") || path.startsWith("/checkout") || path.startsWith("/view_order") || path.startsWith("/show_order_detail") || path.startsWith("/cancel_order"))) {
			httpRequest.getRequestDispatcher("frontend/login.jsp").forward(request, response);
		} else {
			chain.doFilter(httpRequest, httpResponse);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
