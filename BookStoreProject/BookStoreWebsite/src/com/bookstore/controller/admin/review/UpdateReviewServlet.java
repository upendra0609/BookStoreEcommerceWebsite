package com.bookstore.controller.admin.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Review;
import com.bookstore.service.ReviewServices;


@WebServlet("/admin/update_review")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		
		ReviewServices reviewServices = new ReviewServices();
		
		Review review = reviewServices.getReview(reviewId);
		
		if (review != null) {
			String headline = request.getParameter("headline");
			String comment = request.getParameter("comment");
			
			review.setHeadline(headline);
			review.setComment(comment);
			
			Review updateUser = reviewServices.updateReview(review);
			if (updateUser != null) {
				request.getSession().setAttribute("message", "Review with id " + reviewId + " updated succesfully");
				response.sendRedirect("list_review");
			}else {
				request.getSession().setAttribute("message", "Something Went wrong");
				response.sendRedirect("list_review");
			}

		} else {
			request.setAttribute("message", "Could not find Review with ID " + reviewId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
