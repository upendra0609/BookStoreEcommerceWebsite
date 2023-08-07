<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<title>Write a review - Online Book Store</title>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script type="text/javascript" src="./js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="./js/jquery.validate.min.js"></script>
<script type="text/javascript" src="./js/jquery.richtext.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css"  media="all"/>
<link rel='stylesheet' type='text/css' media='screen' href='./bootstrap/bootstrap.css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
</head>
<body>

 <jsp:directive.include file="header.jsp"/>
 
<div class="col-md-12 container-fluid">


    <div class="col-md-12">
          <div class="col-md-2"></div>
          <div class="col-md-8">
	           <div class="col-md-4">
		           <h3><b>Your Review</b></h3>
		       </div>
		       <div class="col-md-8">
		           <h3 align="right"><b>${loggedCustomer.fullName}</b></h3>
		       </div>
		       <hr style="border: 2px solid black;" width="100%"/>
          </div>
	      <div class="col-md-2"></div>
    </div>
    
    <div class="col-md-12">
         <div class="col-md-2"></div>
         <div class="col-md-8">
            <h3 align="left">${book.title}</h3>
         </div>
         <div class="col-md-2"></div>
    </div>
    
    <div class="col-md-12" style="height:400px;">
           <div class="col-md-2"></div>
           <div class="col-md-3" class="content" >
			   <img class="thumbnail" src="data:image/jpg;base64,${book.getBase64Image()}" width="90%" height="280px"/>
		   </div>
		   <div class="col-md-5">
		   <br><br><br><br><br>
		       <h3 align="center">${reviewMessage}</h3>
		   </div>
		   <div class="col-md-2"></div>
    </div>
 
</div>
 
 
 <jsp:directive.include file="footer.jsp" />

</body>
</html>