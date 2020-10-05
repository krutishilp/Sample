<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All</title>
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
		<h3>All Products</h3>
		<c:if test="${empty list}">
			<p>No items Found !!!</p>
		</c:if>
		<c:set var="count" value="${0}"></c:set>
		<table class="table table-bordered table-hover">
			<tbody>
				<tr>
					<c:forEach items="${list}" var="temp">
						<c:set var="count" value="${count+1}"></c:set>
						<td width="13%"><a href="getProductDetails/${temp.productId}">${temp.productName}</a></td>
						<c:if test="${count%3==0}">
							</tr>
						</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>