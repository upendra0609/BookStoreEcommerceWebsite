<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer order Evergreen Bookstore</title>
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
    
<div class="container-fluid col-md-12" style="height:15px"></div>    
    
    <div align="center">
		<c:if test ="${message!=null}">
		     <h4 class="message">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
   
	<div align="center"> 
		<h3>Details of Order ID:${order.orderId}</h3>
	</div>
	
		<div align="center"><h4>Order Overview</h4></div>
	
<div class="container-fluid col-sm-offset-3 col-md-6" align="center">
		   <table class="table table-bordered table-hover">
		     <tr>
		        <td ><b>Order By:</b></td>
		        <td>${order.customer.fullName}</td>
		     </tr>
		     <tr>
		        <td align="left"><b>Book Copies:</b></td>
		        <td >${order.getTotalQuantity()}</td>
		     </tr>
		     <tr>
		        <td ><b>Total Amount:</b></td>
		        <td >Rs.${order.orderTotal}</td>
		     </tr>
		     <tr>
		        <td ><b>Recipient Name:</b></td>
		        <td >${order.recipientName}</td>
		     </tr>
		     <tr>
		        <td ><b>Recipient Phone:</b></td>
		        <td >${order.recipientPhone}</td>
		     </tr>
		     <tr>
		        <td><b>Ship To:</b></td>
		        <td >${order.shippingAddress}</td>
		     </tr>
		     <tr>
		        <td ><b>Payment Method:</b></td>
		        <td >${order.paymentMethod}</td>
		     </tr>
		      <tr>
		        <td ><b>Order Status:</b></td>
		        <td >${order.status}</td>
		     </tr>
		      <tr>
		        <td ><b>Order Date:</b></td>
		        <td >${fn:substring(order.orderDateTime,0,16)}</td>
		     </tr>
		   </table>
</div>



<div class="container-fluid col-sm-offset-2 col-md-8">
    <div class="container-fluid col-md-12" align="center"> 
		<h4>Ordered Books:</h4>
    </div>
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Index</th>
				<th>Book Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Sub Total</th>
			</tr>
			<c:forEach var="orderDetail" items="${order.getOrderDetail()}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${fn:substring(orderDetail.book.title,0,30)}...</td>
					<td>${fn:substring(orderDetail.book.author,0,15)}...</td>
					<td>${orderDetail.book.price}</td>
					<td>${orderDetail.quantity}</td>
					<td>${orderDetail.subtotal}</td>
				</tr>
			</c:forEach>
			<tr>
			   <td colspan="4" align="right"><i><b>Total:</b></i></td>
			   <td><b>${order.getTotalQuantity()}</b></td>
			   <td><b>Rs.${order.orderTotal}</b></td>
			</tr>
		</table>
	</div>
	
		<div align="center">
		   <button type="submit" id="buttonEditOrder">Edit this Order</button>
		   <button class="btn btn-danger" type="submit" id="buttonDeleteOrder">Delete this Order</button>
		</div>
</div>
		
<div class="container-fluid col-md-12" style="height:15px"></div>
		
    <jsp:directive.include file="footer.jsp" />
    
    
    
<script type="text/javascript">
  $(document).ready(function(){
	  
		  $('#buttonEditOrder').click(function(){
			  window.location = "edit_order?id="+${order.orderId};	  
		  });
		  $('#buttonDeleteOrder').click(function(){
			  if(confirm('are you sure you want to delete order with ID '+${order.orderId}+' ?')){
			  window.location = "delete_order?id=${order.orderId}";
			  }
		  });
  });
</script>

</body>
</html>