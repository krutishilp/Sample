<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
	<h1>${msg}</h1>
	<form action="deleteProductById">
		Product Id:<input type="number" name="productId"> <input type="submit"
			value="Get Product">
	</form>
</body>
</html>