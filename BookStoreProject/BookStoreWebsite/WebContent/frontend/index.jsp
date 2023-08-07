<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<title>Evergreen Books- online book store</title>
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
        <div>
	       <h3 id="heading" class="pageheading"><i><b>New</b></i></h3>
			  <c:forEach var="book" items="${listNewBook}">
			          <div class="col-md-2 col-sm-6 col-xs-12">
			                <a href="view_book?id=${book.bookId}" class="thumbnail">
							          <img src="data:image/jpg;base64,${book.getBase64Image()}" style="height:180px; width:100%"/>
							</a>
							<div align="center">
							    <a href="view_book?id=${book.bookId}">
							         <h6><b>${fn:substring(book.title,0,20)}...</b></h6> 
							    </a>
							<h6>
								<a href="view_book?id=${book.bookId}">
								    <c:forTokens items="${book.getStarRating()}" delims="," var="star">
								       <c:if test ="${star eq 'on'}" >
			                             <img src="./images/rating_on.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'off'}" >
			                             <img src="./images/rating_off.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'half'}" >
			                             <img src="./images/rating_half.png"/>
			                           </c:if>
								    </c:forTokens><h7>(${fn:substring(book.getAvgRating(),0,3)})</h7><br>
								    <b>(${book.getReviewCount()} Ratings)</b>
								</a>
							</h6>
								<h6>by ${fn:substring(book.author,0,20)}...</h6>
								<h6><b>Rs. ${book.price}</b></h6>
							</div>    
			            </div>  
			  </c:forEach>   
        </div>
        
        
        <div>
	       <h3 id="heading" class="pageheading"><i><b>Most Selling</b></i></h3>
			  <c:forEach var="orderDetail" items="${mostSellingBook}">
			          <div class="col-md-2 col-sm-6 col-xs-12">
			                <a href="view_book?id=${orderDetail.book.bookId}" class="thumbnail">
							          <img src="data:image/jpg;base64,${orderDetail.book.getBase64Image()}" style="height:180px; width:100%"/>
							</a>
							<div align="center">
							    <a href="view_book?id=${orderDetail.book.bookId}">
							         <h6><b>${fn:substring(orderDetail.book.title,0,20)}...</b></h6> 
							    </a>
							<h6>
								<a href="view_book?id=${orderDetail.book.bookId}">
								    <c:forTokens items="${orderDetail.book.getStarRating()}" delims="," var="star">
								       <c:if test ="${star eq 'on'}" >
			                             <img src="./images/rating_on.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'off'}" >
			                             <img src="./images/rating_off.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'half'}" >
			                             <img src="./images/rating_half.png"/>
			                           </c:if>
								    </c:forTokens><h7>(${fn:substring(orderDetail.book.getAvgRating(),0,3)})</h7><br>
								    <b>(${orderDetail.book.getReviewCount()} Ratings)</b>
								</a>
							</h6>
								<h6>by ${fn:substring(orderDetail.book.author,0,20)}...</h6>
								<h6><b>Rs. ${orderDetail.book.price}</b></h6>
							</div>    
			            </div>  
			  </c:forEach>   
        </div>
        
        
        
        <div>
	       <h3 id="heading" class="pageheading"><i><b>Most Favoured</b></i></h3>
			  <c:forEach var="review" items="${mostFavouredBook}">
			          <div class="col-md-2 col-sm-6 col-xs-12">
			                <a href="view_book?id=${review.book.bookId}" class="thumbnail">
							          <img src="data:image/jpg;base64,${review.book.getBase64Image()}" style="height:180px; width:100%"/>
							</a>
							<div align="center">
							    <a href="view_book?id=${review.book.bookId}">
							         <h6><b>${fn:substring(review.book.title,0,20)}...</b></h6> 
							    </a>
							<h6>
								<a href="view_book?id=${review.book.bookId}">
								    <c:forTokens items="${review.book.getStarRating()}" delims="," var="star">
								       <c:if test ="${star eq 'on'}" >
			                             <img src="./images/rating_on.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'off'}" >
			                             <img src="./images/rating_off.png"/>
			                           </c:if>
			                           <c:if test ="${star eq 'half'}" >
			                             <img src="./images/rating_half.png"/>
			                           </c:if>
								    </c:forTokens><h7>(${fn:substring(review.book.getAvgRating(),0,3)})</h7><br>
								    <b>(${review.book.getReviewCount()} Ratings)</b>
								</a>
							</h6>
								<h6>by ${fn:substring(review.book.author,0,20)}...</h6>
								<h6><b>Rs. ${review.book.price}</b></h6>
							</div>    
			            </div>  
			  </c:forEach>   
        </div>
     </div>
     <br>
     
     <jsp:directive.include file="footer.jsp" />
</body>
</html>