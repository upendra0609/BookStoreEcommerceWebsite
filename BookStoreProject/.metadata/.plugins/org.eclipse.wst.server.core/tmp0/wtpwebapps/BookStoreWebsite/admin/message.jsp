<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css"  media="all"/>
<meta charset="ISO-8859-1">
<title>Message</title>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
  
    <jsp:directive.include file="header.jsp" />
    
	<div align="center"> 
		<c:if test ="${message!=null}">
		     <h4 class="warningmessage">
		        ${message}
	         </h4>
	         <c:remove var="message" scope="session"/>
		</c:if>
	</div>
    
    <jsp:directive.include file="footer.jsp" />

</body>
</html>