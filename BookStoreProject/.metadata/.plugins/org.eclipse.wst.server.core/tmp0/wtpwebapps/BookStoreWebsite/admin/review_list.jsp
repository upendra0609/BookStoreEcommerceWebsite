<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Review - Evergreen Bookstore Administration</title>
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
   <jsp:directive.include file="header.jsp"/>
   
<div class="container-fluid col-md-12" style="height:15px"></div>
   
	
   
<div class="container-fluid col-sm-offset-2 col-md-8">
  <div align="center">
		<h2 class="pageheading">Review Management</h2>
	</div>

     	<div align="center">
		<c:if test ="${message!=null}">
		     <h4 class="message">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
   
   
<div class="container-fluid col-md-12" style="height:15px"></div>

  <table class="table table-bordered table-hover">
     		<tr>
				<th>Index</th>
				<th>Id</th>
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
				<th>Action</th>
			</tr>
			<c:forEach var="review" items="${listReview}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${review.reviewId}</td>
					<td>${review.book.title}</td>
					<td>${review.rating}</td>
					<td>${review.headline}</td>
					<td>${review.customer.fullName}</td>
					<td>${review.reviewTime}</td>
					<td>
					    <a href="edit_review?id=${review.reviewId}">Edit</a>&nbsp; 
					    <a href="javascript:void(0);" class="deletelink" id="${review.reviewId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
  </table>
</div>

<script type="text/javascript">
  $(document).ready(function(){
	  $(".deletelink").each(function(){
		  $(this).on("click",function(){
			  reviewId=$(this).attr("id");
			  if(confirm('are you sure you want to delete review with ID '+reviewId+' ?')){
			  window.location.replace("delete_review?id="+reviewId);
		     }		  
		  });
	  });
  });
</script>

   <jsp:directive.include file="footer.jsp"/>

</body>
</html>