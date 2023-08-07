<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Category - Evergreen Bookstore Administration</title>
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
		<h2 class="pageheading">User Management</h2>
		<h3>
			<a href="category_form.jsp">Create New Category</a>
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
				<th>Category-Id</th>
				<th>Category Name</th>
				<th>Action</th>
			</tr>
			<c:forEach var="category" items="${listCategory}" varStatus="status">
				 <tr>
					<td>${status.count}</td>
					<td>${category.categoryId}</td>
					<td>${category.categoryName}</td>
					<td><a href="edit_category?id=${category.categoryId}">Edit</a>&nbsp; 
					<a href="javascript:void(0);" class="deletelink" id="${category.categoryId}">Delete</a></td>
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
			  categoryId=$(this).attr("id");
			  if(confirm('are you sure you want to delete user with ID '+categoryId+' ?')){
			  window.location.replace("delete_category?id="+categoryId);
		     }		  
		  });
	  });
  });
</script>

</body>
<script type="text/javascript">
  function confirmDelete(categoryId){
	  if(confirm('are you sure you want to delete category with ID '+categoryId+' ?')){
		  window.location.replace("delete_category?id="+categoryId);
	  }
  }
</script>
</html>