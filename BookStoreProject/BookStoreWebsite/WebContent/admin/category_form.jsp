<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>Create New Category</title>
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

<div align = "center">   
		  <c:if test ="${category!=null}">
		           <h2 class="pageheading">Edit User</h2>
		  </c:if>
		 <c:if test ="${category==null}">
             <h2 class="pageheading">Create New User</h2>
	     </c:if>
</div>
	    
	  
	  
	  
<div class="container-fluid col-sm-offset-2 col-md-8">	
       <c:if test ="${category!=null}">
		      <form class="form-horizontal" action="update_category?categoryId=${category.categoryId}" method="post" id="categoryform">
	    </c:if>
		<c:if test ="${category==null}">
		      <form class="form-horizontal" action="create_category" method="post" id="categoryform">
	    </c:if>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="categoryName">Category Name:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="Enter Category" value="${category.categoryName}">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-4">
	          <c:if test ="${category!=null}">
					<button type="submit" value="Update" class="btn btn-primary">Update</button>
			 </c:if>
			 <c:if test ="${category==null}">
				<button type="submit" class="btn btn-primary">Save</button>&emsp;
			 </c:if>
	      <button type="button" class="btn btn-danger" id="buttoncancel">Cancel</button>
	    </div>
	  </div>
</form>
</div>	  
	  
	     
     <jsp:directive.include file="footer.jsp"/>
     
 <script type="text/javascript">
	$(document).ready(function() {

		$("#categoryform").validate({

			rules : {
				categoryName : "required",
			},

			messages : {

				fullname : "Please enter full name",
			}

		});

		$("#buttoncancel").click(function(){
			history.go(-1);
		});
	});
</script>    
     

</body>
</html>