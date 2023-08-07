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
<script type="text/javascript" src="./js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="./js/jquery.validate.min.js"></script>
<script type="text/javascript" src="./js/jquery.richtext.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css"
	media="all" />
<link rel='stylesheet' type='text/css' media='screen'
	href='./bootstrap/bootstrap.css'>
</head>
<body>
     
    <jsp:directive.include file="header.jsp" />
    
<div class="container-fluid col-md-12" style="height:15px"></div>    
    
   
	<div align="center"> 
		<h3>Your Order ID:${order.orderId}</h3>
	</div>
	
	
<div class="container-fluid col-sm-offset-3 col-md-6" align="center">
		   <table class="table table-bordered table-hover">
		     <tr>
		        <td><b>Order Status:</b></td>
		        <td>${order.status}</td>
		     </tr>
		     <tr>
		        <td ><b>Order Date:</b></td>
		        <td >${fn:substring(order.orderDateTime,0,16)}</td>
		     </tr>
		     <tr>
		        <td align="left"><b>Quantity:</b></td>
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
				<th colspan="2">Book</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Sub Total</th>
				<th>Action</th>
			</tr>
			<c:forEach var="orderDetail" items="${order.getOrderDetail()}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>
		                  <a href="view_book?id=${orderDetail.book.bookId}"
									class="thumbnail"> <img alt=""
										src="data:image/jpg;base64,${orderDetail.book.getBase64Image()}"
										style="heigth:20px; width:50px" />
						   </a>
					</td> 
					<td>
					    <a href="view_book?id=${orderDetail.book.bookId}"><b><i>${fn:substring(orderDetail.book.title,0,40)}...</i></b>
						</a>
					</td>
					<td>${fn:substring(orderDetail.book.author,0,15)}...</td>
					<td>${orderDetail.book.price}</td>
					<td>${orderDetail.quantity}</td>
					<td>${orderDetail.subtotal}</td>
					<td>
					    <c:if test="${orderDetail.bookOrder.status  eq 'Delivered'}">
					         <a href="write_review?bookId=${orderDetail.book.bookId}">write review</a>
					    </c:if>  
					</td>
				</tr>
			</c:forEach>
			<tr>
			   <td colspan="5" align="right"><i><b>Total:</b></i></td>
			   <td><b>${order.getTotalQuantity()}</b></td>
			   <td><b>Rs.${order.orderTotal}</b></td>
			</tr>
		</table>
	</div>
</div>
		
		      <div class="container-fluid col-md-12" align="center">
		     		<c:choose>
					     <c:when test="${order.status  eq 'Cancelled'}">
					     </c:when>
					     <c:when test="${order.status  eq 'Delivered'}">
					     </c:when>
					     <c:otherwise>
					          <a href="javascript:void(0);" class="buttonCancelOrder" id="${order.orderId}">
		                           <button class="btn btn-danger">Cancel Order</button>
		                      </a>
					     </c:otherwise>
					</c:choose>
		      </div>
		
		
		
<div class="container-fluid col-md-12" style="height:15px"></div>
		
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