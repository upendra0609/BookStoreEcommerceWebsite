<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<title>Result for ${keyword}- online book store</title>
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
 <div align="center" class="container">
    <c:if test="${fn:length(listBook)==0}">
        <h2>No Result for '${keyword}'</h2>
	</c:if>
	<c:if test="${fn:length(listBook)>0}">
	   <h4 align="center">Search Result for '${keyword}'</h4>
	   <hr width="20%"><br>
	   
<c:forEach var="book" items="${listBook}">	   
<div class="container-fluid col-md-12"  style="height:150px;">	   
		      
		      
		       <div class="col-md-2" >
		            <a  href="view_book?id=${book.bookId}">
		            <img class="thumbnail" src="data:image/jpg;base64,${book.getBase64Image()}" style="height:150px; width:80%" />
		            </a>
		       </div>
		       
		       
		       <div class="col-md-6">
			        <a href="view_book?id=${book.bookId}">
			           <b><h4 align="left">${fn:substring(book.title,0,50)}...</h4></b>
			        </a>
		            <h5  align="left">
		            <b>
		            <c:forTokens items="${book.getStarRating()}" delims="," var="star">
		               <a href="view_book?id=${book.bookId}">
								       <c:if test ="${star eq 'on'}" >
			                             <img src="./images/rating_on.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'off'}" >
			                             <img src="./images/rating_off.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'half'}" >
			                             <img src="./images/rating_half.png"/>
			                           </c:if>
							  </c:forTokens>
							  <h7>(${fn:substring(book.getAvgRating(),0,3)})</h7>
							  <b>(${book.getReviewCount()} Ratings)</b>
					  </a>
		            
		            </b></h5>
		            <h6  align="left"><b>by ${book.author}</b></h6><br>
		            <p style="margin-bottom:0;" align="left">${fn:substring(book.description,0,70)}...</p>	   
		       </div>
		       
		       <div class="col-md-4" align="center">
		           <h2>RS ${book.price}</h2>
		           <a href="add_to_cart?bookId=${book.bookId}"><button>Add to Cart</button></a>
		       </div>
		       
		       
</div>	
<div class="container-fluid col-md-12"  style="height:15px;"></div>	              
	   </c:forEach>
    </c:if>
 </div>
<br><br><br>

<jsp:directive.include file="footer.jsp" />

</body>
</html>