<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>View Order - Evergreen Bookstore Administration</title>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script type="text/javascript" src="./js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="./js/jquery.validate.min.js"></script>
<script type="text/javascript" src="./js/jquery.richtext.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css"  media="all"/>
<link rel='stylesheet' type='text/css' media='screen' href='./bootstrap/bootstrap.css'>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	
 <div align="center">
		<c:if test ="${message!=null}">
		     <h4 class="message">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
	
	
	<div align="center">
		<h2 class="pageheading">My Order History</h2>
	</div>
	
<div class="container-fluid col-sm-offset-2 col-md-8">
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Index</th>
				<th>Order Id</th>
				<th>Quantity</th>
				<th>Total Amount</th>
				<th>Order Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			<c:forEach var="order" items="${orderList}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${order.orderId}</td>
					<td>${order.getTotalQuantity()}</td>
					<td>Rs ${order.orderTotal}</td>
					<td>${fn:substring(order.orderDateTime,0,16)}</td>
					<td>${order.status}</td>
					<td>
					  
					          <a href="show_order_detail?id=${order.orderId}">Detail</a>&nbsp;
				 <!-- <a href="javascript:void(0);" class="buttonCancelOrder" id="${order.orderId}">Cancel</a>&nbsp;  -->
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

	<jsp:directive.include file="footer.jsp" />



<script type="text/javascript">
  $(document).ready(function(){
	  $(".buttonCancelOrder").each(function(){
		  $(this).on("click",function(){
			  orderId=$(this).attr("id");
			  if(confirm('are you sure you want to cancel order with ID '+orderId+' ?')){
			  window.location.replace("cancel_order?id="+orderId);
		     }		  
		  });
	  });
  });
</script>
</body>
</html>