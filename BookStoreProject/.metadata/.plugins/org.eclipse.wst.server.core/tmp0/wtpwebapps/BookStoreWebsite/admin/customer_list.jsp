<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Customer - Evergreen Bookstore Administration</title>
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
		<h2 class="pageheading">Customer Management</h2>
		<h3>
			<a href="customer_form.jsp" class="pageheading">Create New Customer</a>
		</h3>
	</div>
	<div align="center">
		<c:if test ="${message!=null}">
		     <h4 class="message">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
	
<div class="container-fluid col-sm-offset-2 col-md-8">
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Index</th>
				<th>Id</th>
				<th>E-mail</th>
				<th>Full-Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Registered Date</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${customer.customerId}</td>
					<td>${customer.email}</td>
					<td>${customer.fullName}</td>
					<td>${customer.city}</td>
					<td>${customer.country}</td>
					<td>${customer.registerDate}</td>
					<td>
					    <a href="edit_customer?id=${customer.customerId}">Edit</a>&nbsp; 
					    <a href="javascript:void(0);" class="deletelink" id="${customer.customerId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

	<jsp:directive.include file="footer.jsp" />
<script type="text/javascript">
  $(document).ready(function(){
	  $(".deletelink").each(function(){
		  $(this).on("click",function(){
			  customerId=$(this).attr("id");
			  if(confirm('are you sure you want to delete customer with ID '+customerId+' ?')){
			  window.location.replace("delete_customer?id="+customerId);
		     }		  
		  });
	  });
  });
</script>

</body>
</html>