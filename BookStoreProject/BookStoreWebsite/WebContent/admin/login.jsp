<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css"  media="all"/>
<link rel='stylesheet' type='text/css' media='screen' href='../bootstrap/bootstrap.css'><meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

<div align="center">
       <h1>Book Store Administration</h1>
	</div>
	<div align="center">
	    <h2>Admin Login</h2>
</div>

   <div align="center"> 
		<c:if test ="${message!=null}">
		     <h4 class="warningmessage">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>


<form class="form-horizontal" action="login" id="loginform" method="post">
  <div class="form-group">
    <label class="control-label col-sm-4" for="email">Email:</label>
    <div class="col-sm-3 col-md-4">
      <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-4" for="pwd">Password:</label>
    <div class="col-sm-3 col-md-4">
      <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-4 col-sm-10">
      <button type="submit" class="btn btn-primary">Login</button>
    </div>
  </div>
</form>
          
   <script type="text/javascript">
	$(document).ready(function() {

		$("#loginform").validate({

			rules : {

				email : {

					required : true,

					email : true

				},

				password : "required",

			},

			messages : {

				email : {

					required : "Please enter email",

					email : "Please enter an valid email address"

				},

				password : "Please enter password"

			}

		});

	});
</script>
    
</body>
</html>