<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
	<form action="insertProduct">
		<h1>${msg}</h2>
			<!-- productID:<input type="number" name="productId"><br>
 -->
			productName:<input type="text" name="productName"><br>
			productCost:<input type="number" name="productCost"><br>
			<input type="submit" value="Insert Product">
	</form>
</body>
</html>