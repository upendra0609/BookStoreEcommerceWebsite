<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout - Evergreen Bookstore</title>
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


	<div class="container-fluid col-sm-offset-2 col-md-8">
		<div align="center">
			<h3 class="pageheading">Review Your Details&ensp;<a href="view_cart"><i>Edit</i></a></h3>
		</div>
		<c:if test="${!listCart.isEmpty()}">
			<form action="update_cart" method="post">
				<div align="center">
					<table class="table table-bordered table-hover">
						<tr>
							<th>No</th>
							<th colspan="2">Book</th>							
							<th>Author</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Sub-total</th>
						</tr>
						<c:forEach var="cart" items="${listCart}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td> <img alt=""src="data:image/jpg;base64,${cart.book.getBase64Image()}"
										style="heigth:20px; width:20px" />
								</td>
								<td align="left"><b><i>${fn:substring(cart.book.title,0,40)}...</i></b></td>
								<td>${cart.book.author}</td>
								<td>${cart.book.price}</td>
								<td>${cart.quantity}</td>
								<td>${cart.subtotal}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5">Total</td>
							<td><b>${loggedCustomer.getCartQuantity()} books</b></td>
							<td colspan="2"><b>Rs ${loggedCustomer.getCartTotal()}</b></td>
						</tr>
					</table>
				</div>
			</form>
		</c:if>
	</div>
	
	
<div class="container-fluid">
 <form class="form-horizontal" action="place_order" method="post" id="orderform">
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="recipientName">Recipient Name:</label>
	    <div class="col-sm-4 col-md-4">
	      <input type="text" class="form-control" id="recipientName" name="recipientName" placeholder="Enter Recipient Name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="recipientPhone">Recipient Phone:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="recipientPhone" name="recipientPhone" placeholder="Enter Recipient Phone">
	    </div>
	  </div>
	    <div class="form-group">
	    <label class="control-label col-sm-4" for="streetAddress">Street Address:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" name="streetAddress" id="streetAddress" placeholder="Enter Street Address">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="city">City:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="city" name="city" placeholder="Confirm City">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="zipcode">Zip Code:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="Enter Zip Code">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="country">Country:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="country" name="country" placeholder="Enter Country">
	    </div>
	  </div>
	  <div class="form-group">
         <label class="control-label col-sm-4" for="paymentMethod">Choose your payment method:</label>
			<select name="paymentMethod" id="cars">
			  <option value="Cash on delivery" autofocus>Cash on delivery</option>
			  <option value="Credit-Card">Credit-Card</option>
			  <option value="Debit-Card">Debit-Card</option>
			  <option value="Paypal">Paypal</option>
			</select>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-4">
	      <button type="submit" class="btn btn-primary">Place Order</button>&emsp;
	      <button type="button" class="btn btn-primary" id="buttonContinueShoping">Continue Shopping</button>
	    </div>
	  </div>
</form>
</div>


<div class="container-fluid col-sm-offset-2 col-md-8"
		style="height: 25px"></div>
		
		
<jsp:directive.include file="footer.jsp" />


<script type="text/javascript">
		$(document).ready(function() {

			$("#orderform").validate({

				rules : {

					recipientName : "required",
					recipientPhone : "required",
					streetAddress : "required",
					city : "required",
					zipcode : "required",
					country : "required",

				},

				messages : {

					recipientName : "Please enter Recipient Name",
					recipientPhone : "Please Recipient Phone",
					streetAddress : "Please enter Street Address",
					city : "Please enter city",
					zipcode : "Please enter zipcode",
					country : "Please enter country",

				}

			});
			
			  $('#buttonContinueShoping').click(function(){
				  window.location = "./";	  
			  });

		});
	</script>




</body>

</html>