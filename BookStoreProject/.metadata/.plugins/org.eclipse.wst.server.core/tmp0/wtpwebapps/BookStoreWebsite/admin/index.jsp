<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css"  media="all"/>
<link rel='stylesheet' type='text/css' media='screen' href='../bootstrap/bootstrap.css'>
<meta charset="ISO-8859-1">
<title>Bookstore Administration</title>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>
      
     <jsp:directive.include file="header.jsp"/>

    <div align = "center">
         <h2 class="pageheading">Administrative dashboard</h2>
    </div>
    <div align="center">
        <hr width="60%">
        <h2 class="pageheading">Quick Action:</h2>
    </div>
    <div align="center">
      <b>
         <a href="new_book">New Book</a>&ensp;
          <a href="user_form.jsp">New User</a>&ensp;
         <a href="category_form.jsp">New Categories</a>&ensp;
         <a href="customer_form.jsp">New Customers</a>
      </b>
      <hr width="60%">
   </div>
  
  
   
<div class="col-md-12" align="center">
 <div class="container-fluid col-sm-offset-1 col-md-10">
	<div align="center">
		<h2 class="pageheading">Recent Sale:</h2>
	</div>
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Order-Id</th>
				<th>Ordered by</th>
				<th>Book Copies</th>
				<th>Total</th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
			</tr>
			<c:forEach var="order" items="${recentSale}" varStatus="status">
				 <tr>
					<td>${order.orderId}</td>
					<td>${order.customer.fullName}</td>
					<td>${order.getTotalQuantity()}</td>
					<td>${order.orderTotal}</td>
					<td>${order.paymentMethod}</td>
					<td>${order.status}</td>
					<td>${fn:substring(order.orderDateTime,0,16)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
 </div>    
</div>
   
   
   
<div class="col-md-12" align="center">
 <div class="container-fluid col-sm-offset-1 col-md-10">
	<div align="center">
		<h2 class="pageheading">Recent Reviews:</h2>
	</div>
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
			</tr>
			<c:forEach var="review" items="${recentReview}" varStatus="status">
				 <tr>
					<td>${fn:substring(review.book.title,0,40)}</td>
					<td>${review.rating}</td>
					<td>${fn:substring(review.headline,0,35)}</td>
					<td>${review.customer.fullName}</td>
					<td>${fn:substring(review.reviewTime,0,16)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
 </div>    
</div>



<div class="col-md-12" align="center">
       <h2 class="pageheading">Statistics:</h2>
       <div class="container-fluid col-sm-offset-1 col-md-10">
            <div align="center">
		        <table class="table table-hover">
		            <tr>
		                <td>Total User:${userCount}</td>
		                <td>Total Books:${bookCount}</td>
		                <td>Total Customer:${customerCount}</td>
		                <td>Total Reviews:${reviewCount}</td>
		                <td>Total Orders:${orderCount}</td>
		            </tr>
		        </table>
		    </div>
       </div>
</div>
     
     
     <jsp:directive.include file="footer.jsp"/>

</body>
</html>