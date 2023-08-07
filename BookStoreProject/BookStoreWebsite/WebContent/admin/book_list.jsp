<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Books - Evergreen Bookstore Administration</title>
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

<div class="container-fluid col-sm-offset-1 col-md-10">
	<div align="center">
		<h2 class="pageheading">Book Management</h2>
		<h3>
			<a href="new_book" class="pageheading">Create New Book</a>
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
	<div align="center">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Index</th>
				<th>Book-Id</th>
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Price</th>
				<th>Last-Update</th>
				<th>Action</th>
			</tr>
			<c:forEach var="book" items="${listBooks}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${book.bookId}</td>
					<td>
					   <img alt="" src="data:image/jpg;base64,${book.getBase64Image()}" heigth="80px" width="80px"/>
					</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category.categoryName}</td>
					<td>${book.price}</td>
					<td>${book.lastUpdateTime}</td>
					<td>
					  <a href="edit_book?id=${book.bookId}">Edit</a>&nbsp; 
					  <a href="javascript:void(0);" class="deletelink" id="${book.bookId}">Delete</a></td>
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
			  bookId=$(this).attr("id");
			  if(confirm('are you sure you want to delete book with ID '+bookId+' ?')){
			  window.location.replace("delete_book?id="+bookId);
		     }		  
		  });
	  });
  });
</script>

</body>
</html>