<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer profile - Evergreen Bookstore</title>
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
		<h2>Customer profile</h2>
	</div>
	
		<div align="center"><h3>Welcome, ${loggedCustomer.fullName}</h3></div>
	
		<div class="container-fluid col-sm-offset-2 col-md-8" align="center">
		   <table class="table table-bordered table-hover">
		     <tr>
		        <td ><b>Email Address:</b></td>
		        <td>${loggedCustomer.email}</td>
		     </tr>
		     <tr>
		        <td align="left"><b>Full Name:</b></td>
		        <td >${loggedCustomer.fullName}</td>
		     </tr>
		     <tr>
		        <td ><b>Phone Number:</b></td>
		        <td >${loggedCustomer.phone}</td>
		     </tr>
		     <tr>
		        <td ><b>Address:</b></td>
		        <td >${loggedCustomer.address}</td>
		     </tr>
		     <tr>
		        <td ><b>City:</b></td>
		        <td >${loggedCustomer.city}</td>
		     </tr>
		     <tr>
		        <td><b>Zip Code:</b></td>
		        <td >${loggedCustomer.zipcoce}</td>
		     </tr>
		         <tr>
		        <td ><b>Country:</b></td>
		        <td >${loggedCustomer.country}</td>
		     </tr>
		   </table>
		
		
		<div align="center">
		   <button type="submit" id="buttonEditProfile">Edit My Profile</button>
		</div>
		</div>
		
<div class="container-fluid col-md-12" style="height:15px"></div>
		
    <jsp:directive.include file="footer.jsp" />
    
    
    
<script type="text/javascript">
  $(document).ready(function(){
	  
		  $('#buttonEditProfile').click(function(){
			  window.location = "edit_customer?id="+${loggedCustomer.customerId};	  
		  });
  });
</script>

</body>
</html>