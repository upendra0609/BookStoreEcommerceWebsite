<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css" media="all" />

<meta charset="ISO-8859-1">
<title>Create New Book</title>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>
	   
	<jsp:directive.include file="header.jsp" />

	<div align="center" class="container">
		<c:if test="${book!=null}">
			<h2 class="pageheading">Edit Book</h2>
		</c:if>
		<c:if test="${book==null}">
			<h2 class="pageheading">Create New Book</h2>
		</c:if>
	</div>

	<div align="center" >
		<c:if test="${book!=null}">
			<form action="update_book?bookId=${book.bookId}" method="post" id="bookform" enctype="multipart/form-data">
		</c:if>
		<c:if test="${book==null}">
			<form action="create_book" method="post" id="bookform" enctype="multipart/form-data">
		</c:if>
		<table class="form">
			<tr>
			     <td align="right">
			        <label for="category">Category:</label>
			     </td>
			     <td align="left">
			         <select name="category" id="category">
			            <c:forEach var="category" items="${categoryList}">
			                <c:if test ="${category.categoryId eq book.category.categoryId}" >
			                    <option value ="${category.categoryId}" selected>
			                </c:if>
			                <c:if test ="${category.categoryId ne book.category.categoryId}" >
			                    <option value ="${category.categoryId}">
			                </c:if>
			                 ${category.categoryName}</option>
			            </c:forEach>
				    </select>
			     </td> 
			</tr>
			<tr>
				<td >Title:</td>
				<td ><input type="text" id="title" name="title" value="${book.title}" size="20"/></td>
			</tr>
			<tr>
				<td >Author:</td>
				<td ><input type="text" id="author" name="author" value="${book.author}" size="20"/></td>
			</tr>
			<tr>
				<td >ISBN:</td>
				<td ><input type="text" id="isbn" name="isbn" value="${book.isbn}" size="20"/></td>
			</tr>
			<tr>
				<td >Publish Date:</td>
				<td ><input type="date" id="publishDate" name="publishDate" value="${book.publishDate}" size="20"/></td>
			</tr>
			<tr>
				<td >Book Image:</td>
				<td>
				    <input type="file" id="image" name="image" size="20"/><br>
				    <img alt="Image Preview" id="thumbnail"  style="width:60px; margin-top:5px" src="data:image/jpg;base64, ${book.getBase64Image()}"/>
				</td>
			</tr>
			<tr>
				<td >Price:</td>
				<td ><input type="text" id="price" name="price" value="${book.price}" size="20"/></td>
			</tr>
			<tr>
				<td >Description:</td>
				<td ><textarea id="description" name="description"  rows="3" cols="20">${book.description}</textarea></td>
			</tr>
			<tr>
				<td>&ensp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><c:if test="${book!=null}">
						<button type="submit" value="Update">Update</button>
					</c:if> <c:if test="${book==null}">
						<button type="submit">Save</button>
						&emsp;
					</c:if>
					<button type="button" id="buttoncancel">Cancel</button></td>
			</tr>
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />


<script type="text/javascript">
	$(document).ready(function() {
		

		$('#image').change(function(){
			showImageThumbnail(this)
		});
		$("#bookform").validate({

			rules : {

				title : "required",

				author : "required",
				isbn : "required",
				publishDate : "required",
				<c:if test="$book==null">
				    image : "required",
				</c:if>
				price : "required",
				description : "required",

			},

			messages : {

				fullname    : "Please enter title",
				author      : "Please enter auther",
				isbn        : "Please enter isbn",
				publishDate : "Please enter publishDate",
				image       : "Please enter image",
				price       : "Please enter price",
				description : "Please enter description",

			}

		});
		
		
		$("#buttoncancel").click(function(){
			history.go(-1);
		});

	});
	
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e){
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}
</script>

</body>
</html>