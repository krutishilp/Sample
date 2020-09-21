<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
	<form action="updateProd">
		<h1>${msg}</h2>
			productId:<input type="number" name="productId"><br>
			productName:<input type="text" name="productName"><br>
			productCost:<input type="number" name="productCost"><br>
			<input type="submit" value="Update Product">
	</form>
</body>
</html>