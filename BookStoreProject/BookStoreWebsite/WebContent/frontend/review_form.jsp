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
	               <c:if test="${review!=null}">
	                   <h3>You already wrote a review for this book</h3>
	               </c:if>
	               <c:if test="${review==null}">
	                    <h3><b>Your Review</b></h3>
	               </c:if>
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
		        <form class="form-horizontal" action="submit_review" id="reviewForm" method="post">
		             <div id="rateYo"></div>
		             
		             <div class="form-group">
					      <input type="hidden" class="form-control" name="rating" id="rating"/>
					  </div>
					  <div class="form-group">
					      <input type="hidden" class="form-control" name="bookId" value="${book.bookId}"/>
					  </div>	
					  
					 <c:if test="${review==null}">
					      <div class="form-group">
					           <input type="text" class="form-control" name="headline" id="headline"  placeholder="Headline or summary for the review(required)">
					      </div>
					      <div class="form-group">
					           <textarea class="form-control" name="comment" id="comment" placeholder="Write your review detail..." rows="7" style="resize:none"></textarea>
					      </div>
			         </c:if>
					 <c:if test="${review!=null}">
					         <div class="form-group">
					             <input type="text" class="form-control" value="${review.headline}" placeholder="Headline or summary for the review(required)" readonly>
						      </div>
						      <div class="form-group">
						          <textarea class="form-control" rows="8" style="resize:none" readonly>${review.comment}</textarea>
						      </div>
		             </c:if>
					  <div class="form-group">
					   <div align="center">
					      <c:if test="${review==null}">
	                          <button type="submit" class="btn btn-primary">Submit</button>&emsp;
					          <button type="button" class="btn btn-danger" id="buttoncancel">Cancel</button>
	                      </c:if>
					    </div>
					  </div>
				</form>
		   </div>
		   <div class="col-md-2"></div>
    </div>
 
</div>
 
 
 <jsp:directive.include file="footer.jsp" />



	<script type="text/javascript">
		$(document).ready(function() {

			$("#reviewForm").validate({

				rules : {

					headline : "required",
					comment : "required",

				},

				messages : {
					headline : "Please enter headline",
					comment : "Please enter comment",

				}

			});

			$("#buttoncancel").click(function() {
				history.go(-1);
			});
			
			
			 $("#rateYo").rateYo({
				    starWidth: "40px",
				   
					<c:if test="${review==null}">
					       onSet: function (rating, rateYoInstance) {
					    	$("#rating").val(rating);
					    }
			         </c:if>
					 <c:if test="${review!=null}">
					     rating: ${review.rating},
					     readOnly: true
		             </c:if>
			         
			     });

		});
	</script>


</body>
</html>