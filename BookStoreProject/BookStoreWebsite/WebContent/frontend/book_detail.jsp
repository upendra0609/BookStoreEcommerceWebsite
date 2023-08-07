<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<title>Book Detail</title>
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
 
  <div class="container-fluid col-md-12">
		                <div class="container col-md-12 col-sm-offset-1">
		                   <h3><b>${book.title}</b></h3>
		                   <h5><b>by ${book.author}</b></h5>
		               </div>
		               
		               
		       <div class="col-md-12">        
				      <div class="col-md-4" class="content" >
					        <img src="data:image/jpg;base64,${book.getBase64Image()}" width="75%" height="250px" align="right"/>
					  </div>
					  <div class="col-md-6" class="content">
					       <h4>
					         <a href="#review">
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
								   </c:forTokens><h7>(${fn:substring(book.getAvgRating(),0,3)})</h7>
					            <b>(${book.getReviewCount()} Ratings)</b>
					            </a>
					         </h4>
					         <textarea rows="11" cols="70" style="resize:none;border:none;" readonly>${book.getDescription()}</textarea>
					   </div>
					   <div class="col-md-2" class="content">
					       <h2><b>Rs${book.price}</b></h2><br>
					       <a href="add_to_cart?bookId=${book.bookId}"><button>Add to Cart</button></a>
					   </div>	   
           </div>
           
           </div>
           <br><br>
           
           <div class="container-fluid col-md-12">
                       <div class="col-md-6" id="review">
					      <h3><b>&emsp;&emsp;&emsp;&emsp;Customer Review</b></h3>
					   </div>
					   <div class="col-md-6">
				   <!--      <button type="submit" id="buttonWriteReview">Write a customer review</button>  -->
				       </div>
           </div>
           
           <div class="container-fluid col-md-12" style="height:20px;"></div>
           <div class="container-fluid col-md-12">
                  <div class="col-md-1"></div>
		           <div class="col-md-8">
		              <c:forEach items="${book.reviewSet}" var="review">
		                 <div style="height:100px;">
		                     <c:forTokens items="${review.getStarRating()}" delims="," var="star">
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
								<b>(${review.rating}) &ensp;<font size="+0.1">-${review.headline}!</font></b>
								<h5>by <b>${review.customer.fullName}</b> on <font size="+0.1">${fn:substring(review.reviewTime,0,10)}</font></h5>
								<p><i>${review.comment}</i></p>	                 
		                 </div>
		              </c:forEach>
		           </div>
           <div class="col-md-3"></div>
           </div>
          
     <jsp:directive.include file="footer.jsp" />

<script type="text/javascript">
  $(document).ready(function(){
		  $('#buttonWriteReview').click(function(){
			  window.location = "write_review?bookId="+${book.bookId};	  
		  });
  });
</script>


</body>
</html>