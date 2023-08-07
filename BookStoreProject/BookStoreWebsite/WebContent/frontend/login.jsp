<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>Customer Login</title>
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
    <jsp:directive.include file="header.jsp"/>
   
	<div align="center">
	    <h2>Customer Login</h2>
	</div>
	<br>
	<div align="center"> 
		<c:if test ="${message!=null}">
		     <h4 class="warningmessage">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
	
<br><br>		
		
<div class="container-fluid">	
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
    <div class="col-sm-offset-4 col-sm-4">
      <button type="submit" class="btn btn-primary">Login</button>
    </div>
  </div>
</form>
</div>
<br><br><br><br><br>
       
<jsp:directive.include file="footer.jsp" />
   
   
   
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