<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Order - Evergreen Bookstore Administration</title>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css"  media="all"/>
<link rel='stylesheet' type='text/css' media='screen' href='../bootstrap/bootstrap.css'>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">Order Management</h2>
	</div>
	<div align="center">
		<c:if test ="${message!=null}">
		     <h4 class="message">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
	
<div class="container-fluid col-sm-offset-1 col-md-10">
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Index</th>
				<th>Order Id</th>
				<th>Ordered by</th>
				<th>Book Copies</th>
				<th>Total</th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
				<th>Action</th>
			</tr>
			<c:forEach var="order" items="${orderList}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${order.orderId}</td>
					<td>${order.customer.fullName}</td>
					<td>${order.getTotalQuantity()}</td>
					<td>${order.orderTotal}</td>
					<td>${order.paymentMethod}</td>
					<td>${order.status}</td>
					<td>${fn:substring(order.orderDateTime,0,10)}</td>
					<td>
					    <a href="view_order?id=${order.orderId}">Detail</a>&nbsp;
					    <a href="edit_order?id=${order.orderId}">Edit</a>&nbsp;
					    <a href="javascript:void(0);" class="deletelink" id="${order.orderId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

	<jsp:directive.include file="footer.jsp" />
<script type="text/javascript">
  $(document).ready(function(){
	  $(".deletelink").each(function(){
		  $(this).on("click",function(){
			  orderId=$(this).attr("id");
			  if(confirm('are you sure you want to delete customer with ID '+orderId+' ?')){
			  window.location.replace("delete_order?id="+orderId);
		     }		  
		  });
	  });
  });
</script>

</body>
</html>