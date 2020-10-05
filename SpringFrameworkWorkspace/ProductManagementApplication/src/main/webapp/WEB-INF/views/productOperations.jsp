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
</style>
</head>
<body class="jumbotron">
	<div class="container">
		<h2 style="font-size: 33px">${msg}</h2>
		<br>
		<div>
			<h4>Product</h4>
		</div>

		<form action="productOperations" method="post">
			<div class="form-group">
				<label for="productid">Product Id</label> <input type="number"
					class="form-control" id="productId"
					placeholder="Please Enter Product Id" name="productId"
					value='${product.productId}' required="required" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="productname">Product Name</label> <input type="text"
					class="form-control" id="productname"
					placeholder="Please Enter Product Name" name="productName"
					required="required" value='${product.productName}'>
			</div>

			<div class="form-group">
				<label for="productcost">Product Cost</label> <input type="number"
					class="form-control" id="productcost"
					placeholder="Please Enter Product Cost" name="productCost"
					value='${product.productCost}' required="required">
			</div>


			<div class="form-group">
				<input type="submit" class="btn btn-primary" name="update"
					value="Update Product">
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-danger" name="delete"
					value="Delete Product">
			</div>

		</form>

	</div>


</body>
</html>