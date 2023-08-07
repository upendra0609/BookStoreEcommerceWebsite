<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Shopping Cart</title>
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


<script type="text/javascript">
	// Quantity spin buttons
	function increase_by_one(field) {
		nr = parseInt(document.getElementById(field).value);
		document.getElementById(field).value = nr + 1;
	}

	function decrease_by_one(field) {
		nr = parseInt(document.getElementById(field).value);
		if (nr >= 0) {
			if ((nr - 1) >= 0) {
				document.getElementById(field).value = nr - 1;
			}
		}
	}
</script>

<style type="text/css">
#qty1 {
	width: 25px;
}
</style>


</head>
<body>

	<jsp:directive.include file="header.jsp" />


	<div class="container-fluid col-sm-offset-2 col-md-8">

		<div align="center">
			<c:if test="${message!=null}">
				<h4 class="message">${message}</h4>
				<c:remove var="message" scope="session" />
			</c:if>
		</div>


		<div align="center">
			<h2 class="pageheading">Your Cart Details</h2>
		</div>

		<c:if test="${listCart.isEmpty()}">
			<h2 align="center">There's no item in your cart</h2>
		</c:if>

		<c:if test="${!listCart.isEmpty()}">
			<form action="update_cart" method="post">
				<div align="center">
					<table class="table table-bordered table-hover">
						<tr>
							<th>Index</th>
							<th colspan="2">Book</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Sub-total</th>
						</tr>
						<c:forEach var="cart" items="${listCart}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td><a href="view_book?id=${cart.book.bookId}"
									class="thumbnail"> <img alt=""
										src="data:image/jpg;base64,${cart.book.getBase64Image()}"
										heigth="50px" width="50px" />
								</a></td>
								<td align="left"><a href="view_book?id=${cart.book.bookId}"><b><i>${fn:substring(cart.book.title,0,40)}...</i></b></a></td>
								<td>
									<div class="quantity">
										<input class="number" id="${cart.book.bookId}" type="text"
											value="${cart.quantity}" name="${cart.book.bookId}" size="1"
											readonly />
										<button onclick="increase_by_one('${cart.book.bookId}');">+</button>
										<button onclick="decrease_by_one('${cart.book.bookId}');">-</button>
									</div>
								</td>
								<td>${cart.book.price}</td>
								<td>${cart.subtotal}</td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><b>${loggedCustomer.getCartQuantity()} books<b></b></td>
							<td>Total</td>
							<td colspan="2"><b>Rs ${loggedCustomer.getCartTotal()}<b></b></td>
						</tr>
					</table>
				</div>
				<div class="container-fluid col-md-12">
					<div class="col-md-6" align="left">
					    <a href="clear_cart">
							<button class="btn btn-danger" type="button">Clear Cart</button>
						</a>
					</div>
					<div class="col-md-6" align="right">
						<a href="./">
							<button class="btn btn-success" type="button">Continue Shopping</button>
						</a>
						<a href="checkout">
							<button class="btn btn-success" type="button">Check Out</button>
						</a>
					</div>
					<div class="col-md-2"></div>
				</div>
			</form>

		</c:if>
	</div>

	<div class="container-fluid col-sm-offset-2 col-md-8"
		style="height: 25px"></div>
	<jsp:directive.include file="footer.jsp" />






</body>

</html>