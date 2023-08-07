package com.bookstore.controller.admin.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Review;
import com.bookstore.service.ReviewServices;


@WebServlet("/admin/delete_review")
public class DeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int reviewId = Integer.parseInt(request.getParameter("id"));
			
		ReviewServices reviewServices = new ReviewServices();
		Review review = reviewServices.getReview(reviewId);
		
		
		if(review!=null) {
			reviewServices.deleteReview(reviewId);
			request.getSession().setAttribute("message", "Deleted review with ID "+reviewId);
			response.sendRedirect("list_review");	
		}else {
			request.setAttribute("message", "Could not find review with ID "+reviewId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}



}
