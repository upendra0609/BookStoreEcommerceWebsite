<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<nav class="navbar navbar-default container-fluid navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="./"><b>Evergreen Book</b></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form  action="search" method="get" class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="keyboard" size="60">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
           <c:if test="${loggedCustomer!=null}">
		         <li><a href="view_profile">Welcome, <b>${loggedCustomer.fullName}</b></a></li>
		         <li><a href="view_order">My Order</a></li>
		         <li><a href="logout">Logout</a></li>
		     </c:if>
		     <c:if test="${loggedCustomer==null}">
		         <li><a href="login">Sign In</a></li>
		         <li><a href="register">Register</a></li>
		     </c:if>
		     <li><a href="view_cart">Cart</a></li> 
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<!-- for margin -->
<nav class="navbar navbar-default " >
 <div class="container-fluid">
    <div class="collapse navbar-collapse col-md-12 col-sm-offset-1">
          <ul class="nav navbar-nav centered-ul text-center list-inline">
              <li>
              </li>
          </ul>
      </div>
    </div>
</nav>


<c:if test="${listCategory!=null}">
<nav class="navbar navbar-default">
 <div class="container-fluid" >
    <div class="collapse navbar-collapse col-md-12 col-sm-offset-1">
      <ul class="nav navbar-nav centered-ul text-center list-inline">
          <c:forEach var="category" items="${listCategory}" varStatus="status">
              <li>
                  <a href="view_category?id=${category.categoryId}">
                       <b><c:out value="${category.categoryName}"></c:out></b>
				  </a>
              </li>
          </c:forEach>
      </ul>
      </div>
    </div>
</nav>
</c:if>





 