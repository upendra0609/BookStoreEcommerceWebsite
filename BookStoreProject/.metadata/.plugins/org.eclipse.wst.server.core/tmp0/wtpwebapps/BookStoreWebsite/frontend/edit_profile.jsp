<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Register New Customer</title>
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
		<h2 class="pageheading">Edit My Profile</h2>
	</div>
	<div class="col-md-3"></div>
	
	
	<div align="center" class="col-md-6 container-fluid">
		<form action="update_customer?customerId=${loggedCustomer.customerId}" method="post" id="customerform">
			<table class="form table table-hover">
			    <tr>
			         <td></td>
					 <td align="right">
					    <i>(Email-address cannot changed)</i>
					 </td>
				</tr>
				<tr>
					<td >Email Address:</td>
					<td><input type="text" id="email" value="${editCustomer.email}"
						name="email"  size="20" readonly></td>
				</tr>
				<tr>
					<td >Full-Name:</td>
					<td ><input type="text" id="fullname" value="${editCustomer.fullName}"
						name="fullname"  size="20"></td>
				</tr>
				<tr>
					<td >Phone Number:</td>
					<td ><input type="text" id="phoneNumber" value="${loggedCustomer.phone}"
						name="phoneNumber" size="20"></td>
				</tr>
				<tr>
					<td >Address:</td>
					<td ><input type="text" id="address" value="${loggedCustomer.address}"
						name="address" size="20"></td>
				</tr>
				<tr>
					<td >City:</td>
					<td ><input type="text" id="city" name="city" value ="${loggedCustomer.city}"
						size="20"></td>
				</tr>
				<tr>
					<td >Zip Code:</td>
					<td ><input type="text" id="zipcode" value="${loggedCustomer.zipcoce}"
						name="zipcode" size="20"></td>
				</tr>
				<tr>
					<td >Country:</td>
					<td ><input type="text" id="country" value="${loggedCustomer.country}"
						name="country" size="20"></td>
				</tr>
				<tr>
					 <td colspan="2" align="center">
					    <i>(Leave password field blank if you don't want to change password)</i>
					 </td>
				</tr>
				<tr>
					<td >Password:</td>
					<td ><input type="password" id="password"
						name="password" size="20"></td>
				</tr>
				<tr>
					<td >Confirm Password:</td>
					<td ><input type="password" id="confirmPassword"
						name="confirmPassword" size="20"></td>
				</tr>
				<tr>
					<td>&ensp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Update</button>&emsp;
						<button type="button" id="buttoncancel">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	<div class="col-md-3"></div>
	<jsp:directive.include file="footer.jsp" />


	<script type="text/javascript">
		$(document).ready(function() {

			$("#customerform").validate({

				rules : {

			

					fullname : "required",

					confirmPassword : {
						
						equalTo : '#password'
					},
					phoneNumber : "required",
					address : "required",
					city : "required",
					zipcode : "required",
					country : "required",

				},

				messages : {



					fullname : "Please enter full name",

					password : "Please enter password",
					confirmPassword : {
						equalTo : "confirm password does not match password"
					},
					phoneNumber : "Please phone Number",
					address : "Please enter address",
					city : "Please enter city",
					zipcode : "Please enter zipcode",
					country : "Please enter country",

				}

			});

			$("#buttoncancel").click(function() {
				history.go(-1);
			});

		});
	</script>

</body>
</html>