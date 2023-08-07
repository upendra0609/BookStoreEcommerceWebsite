<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create New User</title>
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
		<c:if test="${user!=null}">
			<h2 class="pageheading">Edit User</h2>
		</c:if>
		<c:if test="${user==null}">
			<h2 class="pageheading">Create New User</h2>
		</c:if>
	</div>
	
	
<div class="container-fluid col-sm-offset-2 col-md-8">
	    <c:if test="${user!=null}">
			<form class="form-horizontal" action="update_user?userId=${user.userId}" method="post" id="userform">
		</c:if>
		<c:if test="${user==null}">
			<form class="form-horizontal" action="create_user" method="post" id="userform">
		</c:if>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="email">Email:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="email" class="form-control" id="email" name="email" placeholder="Enter Category"  value="${user.getEmail()}">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="fullname">Full-Name:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="text" class="form-control" id="fullname"
					name="fullname" value="${user.getFullName()}" placeholder="Enter Full-Name" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-4" for="email">Password:</label>
	    <div class="col-sm-3 col-md-4">
	      <input type="password" class="form-control" id="password" name="password" value="${user.getPassword()}" placeholder="Enter Password">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-4">
	         <c:if test="${user!=null}">
						<button type="submit" value="Update" class="btn btn-primary">Update</button>
			 </c:if> 
			 <c:if test="${user==null}">
						<button type="submit" class="btn btn-primary">Save</button>
					</c:if>
	      <button type="button" class="btn btn-danger" id="buttoncancel">Cancel</button>
	    </div>
	  </div>
</form>
</div>	  

	<jsp:directive.include file="footer.jsp" />


<script type="text/javascript">
	$(document).ready(function() {

		$("#userform").validate({

			rules : {

				email : {

					required : true,

					email : true

				},

				fullname : "required",

				password : "required",

			},

			messages : {

				email : {

					required : "Please enter email",

					email : "Please enter an valid email address"

				},

				fullname : "Please enter full name",

				password : "Please enter password"

			}

		});
		
		
		$("#buttoncancel").click(function(){
			history.go(-1);
		});

	});
</script>

</body>
</html>