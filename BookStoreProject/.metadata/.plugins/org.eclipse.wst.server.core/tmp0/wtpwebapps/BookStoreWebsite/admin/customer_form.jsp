<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create New Customer</title>
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
		<c:if test="${customer!=null}">
			<h2 class="pageheading">Edit Customer</h2>
		</c:if>
		<c:if test="${customer==null}">
			<h2 class="pageheading">Create New Customer</h2>
		</c:if>
	</div>
	
<div class="container-fluid col-sm-offset-2 col-md-8">	
       <c:if test="${customer!=null}">
			<form class="form-horizontal" action="update_customer?customerId=${customer.customerId}" method="post" id="customerform">
		</c:if>
		<c:if test="${customer==null}">
			<form class="form-horizontal" action="create_customer" method="post" id="customerform">
		</c:if>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="email">Email Address:</label>
	    <div class="col-sm-4 col-md-4">
	      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" value="${customer.email}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="fullname">Full Name:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter Full Name" value="${customer.fullName}">
	    </div>
	  </div>
	    <div class="form-group">
	    <label class="control-label col-sm-4" for="password">Password:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" value="${customer.password}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="confirmPassword">Confirm Password:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" value="${customer.password}">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="phoneNumber">Phone Number:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number" value="${customer.phone}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="address">Address:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address" value="${customer.address}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="city">City:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="city" name="city" placeholder="Enter City" value="${customer.city}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="zipcode">Zip Code:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="Enter Zip Code" value="${customer.zipcoce}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="country">Country:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="country" name="country" placeholder="Enter Country" value="${customer.country}">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-4">
	          <c:if test="${customer!=null}">
	                <button type="submit" value="Update" class="btn btn-primary">Update</button>&emsp;
	          </c:if>
	          <c:if test="${customer==null}">
						<button type="submit" class="btn btn-primary">Save</button>&emsp;
			   </c:if>
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
				confirmPassword :{
					required: true,
					equalTo: '#password'
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
				confirmPassword :{
					required: "Please confirm password",
					equalTo: "confirm password does not match password"
				},
				phoneNumber : "Please phone Number",
				address : "Please enter address",
				city : "Please enter city",
				zipcode : "Please enter zipcode",
				country : "Please enter country",

			}

		});
		
		
		$("#buttoncancel").click(function(){
			history.go(-1);
		});
		

	});
</script>

</body>
</html>