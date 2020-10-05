<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place an Product</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<style type="text/css">
.container {
	width: 40%;
	align-items: center;
}
p{
	color: red;
}
</style>
</head>
<body class="jumbotron">
	<div class="container">
	<h2 style="font-size: 33px">${msg}</h2>
	<br>
	<c:if test="${productId>0}">
		<p >Product Inserted Successfully...</p>
	</c:if>
	<c:if test="${isUpdated==true}">
		<p>Product Updated Successfully...</p>
	</c:if>
	<c:if test="${isUpdated==false}">
		<p>Sorry, Product Updation Failed...</p>
	</c:if>
	<c:if test="${isDeleted==true}">
		<p>Product Deleted Successfully...</p>
	</c:if>
	<c:if test="${isDeleted==false}">
		<p>Sorry, Product Deletion Failed...</p>
	</c:if>
		<div>
			<h4>Create Product</h4>
		</div>

		<form action="insertProduct" method="post">
			<div class="form-group">
				<label for="productid">Product Id</label> <input type="number"
					class="form-control" id="productId"
					placeholder="Please Enter Product Id" name="productId"
					required="required" value=''>
			</div>
			<div class="form-group">
				<label for="productname">Product Name</label> <input type="text"
					class="form-control" id="productname"
					placeholder="Please Enter Product Name" name="productName"
					required="required" value=''>
			</div>

			<div class="form-group">
				<label for="productcost">Product Cost</label> <input type="number"
					class="form-control" id="productcost"
					placeholder="Please Enter Product Cost" name="productCost"
					required="required" value=''>
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" name="createProduct"
					required="required">
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Create Product">
			</div>
		</form>
		<!-- <iframe src="displayProducts"></iframe> -->
	</div>
	<div>
		<jsp:include page="displayAllProducts.jsp"></jsp:include>
	</div>
</body>
</html>