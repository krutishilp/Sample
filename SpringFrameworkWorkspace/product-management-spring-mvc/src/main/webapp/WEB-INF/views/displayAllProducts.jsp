<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All</title>
</head>
<body>
	<h2>All Products</h2>

	<table class="table table-striped">
		<thead>
			<tr class="tr tr-success">
				<td>Product Id</td>
				<td>Product Name</td>
				<td>Product Cost</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="temp">
				<tr>
					<td>${temp.productId}</td>
					<td>${temp.productName}</td>
					<td>${temp.productCost}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>