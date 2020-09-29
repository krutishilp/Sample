<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
	<h1>${msg}</h2>
		<%-- <form:errors path="product.*"></form:errors> --%>
		<form:form action="insertProduct" modelAttribute="product">

			<!-- productID:<input type="number" name="productId"><br>
 -->
			productName:<form:input type="text" name="productName" path="productName"></form:input>
			<br>
			productCost:<form:input type="number" name="productCost" path="productCost"></form:input>
			<br>
			<form:errors path="productCost"></form:errors>
			<br>
			<input type="submit" value="Insert Product">
		</form:form>
</body>
</html>