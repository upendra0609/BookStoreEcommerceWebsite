<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Review</title>
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
	
	<div class="container-fluid col-md-12" style="height:15px"></div>

	<div align="center">
			<h2 class="pageheading">Edit Review</h2>
	</div>
	


<div class="container-fluid">
			<form class="form-horizontal" action="update_review?reviewId=${review.reviewId}" method="post" id="reviewform">
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="book">Book:</label>
	    <div class="col-sm-4 col-md-4">
	      <input type="text" class="form-control" id="book" name="book" placeholder="Enter Book" value="${review.book.title}" readonly>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="rating">Rating:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="rating" name="rating" placeholder="Enter rating" value="${review.rating}" readonly>
	    </div>
	  </div>
	    <div class="form-group">
	    <label class="control-label col-sm-4" for="customer">Customer:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" name="customer" id="customer" placeholder="Enter customer" value="${review.customer.fullName}" readonly>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="headline">Headline:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="headline" name="headline" placeholder="Enter headline" value="${review.headline}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="comment">Comment:</label>
	    <div class="col-sm-3 col-md-4">
	      <textarea class="form-control" id="comment" name="comment" placeholder="Enter Comment" rows="3" cols="20">${review.comment}</textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-4">
	      <button type="submit" class="btn btn-primary">Update</button>&emsp;
	      <button type="button" class="btn btn-danger" id="buttoncancel">Cancel</button>
	    </div>
	  </div>
</form>
</div>

	<jsp:directive.include file="footer.jsp" />


<script type="text/javascript">
	$(document).ready(function() {

		$("#reviewform").validate({

			rules : {


				comment : "required",

				headline : "required",

			},

			messages : {


				fullname : "Please enter headline",

				password : "Please enter comment"

			}

		});
		
		
		$("#buttoncancel").click(function(){
			history.go(-1);
		});

	});
</script>

</body>
</html>