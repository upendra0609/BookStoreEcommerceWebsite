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
		<h2 class="pageheading">Register as New Customer</h2>
	</div>	
	
<div class="container-fluid">
 <form class="form-horizontal" action="register_customer" method="post" id="customerform">
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="email">Email:</label>
	    <div class="col-sm-4 col-md-4">
	      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="fullname">Full Name:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter Full Name">
	    </div>
	  </div>
	    <div class="form-group">
	    <label class="control-label col-sm-4" for="password">Password:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="confirmPassword">Confirm Password:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm password">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="phoneNumber">Phone Number:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="address">Address:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="city">City:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="city" name="city" placeholder="Enter City">
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
	    <div class="col-sm-offset-4 col-sm-4">
	      <button type="submit" class="btn btn-primary">Register</button>&emsp;
	      <button type="button" class="btn btn-danger" id="buttoncancel">Cancel</button>
	    </div>
	  </div>
</form>
</div>
	
	
<jsp:directive.include file="footer.jsp" />


<script type="text/javascript">
		$(document).ready(function() {

			$("#customerform").validate({

				rules : {

					email : {

						required : true,

						email : true

					},

					fullname : "required",

					password : "required",
					confirmPassword : {
						required : true,
						equalTo : '#password'
					},
					phoneNumber : "required",
					address : "required",
					city : "required",
					zipcode : "required",
					country : "required",

				},

				messages : {

					email : {

						required : "Please enter email",

						email : "Please enter an valid email address"

					},

					fullname : "Please enter full name",

					password : "Please enter password",
					confirmPassword : {
						required : "Please confirm password",
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