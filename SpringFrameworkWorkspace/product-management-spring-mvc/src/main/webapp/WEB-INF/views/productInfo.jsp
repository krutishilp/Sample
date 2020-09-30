<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
	<%-- <h1>${msg}</h2> --%>
	<div id="app_name">
		<h1>
			<spring:message code="app.name" />
		</h1>
	</div>
	<a id="en" href="/product-management-spring-mvc/productInfo?lang=en">English</a>
	|
	<a id="fr" href="/product-management-spring-mvc/productInfo?lang=fr">French</a>



	<form:errors path="product.*"></form:errors>
	<form action="insertProduct">
		<div id="welcome_text">
			<h2>
				<spring:message code="welcome.message" />
			</h2>
		</div>
		<!-- productID:<input type="number" name="productId"><br>
 -->
		<div id="prod_name">
			<spring:message code="product.name" />
			<input type="text" name="productName" path="productName">
		</div>

		<br>

		<div id="prod_cost">
			<spring:message code="product.cost" />
			<input type="number" name="productCost" path="productCost">
		</div>
		<br> <br> <input type="submit" value="Insert Product">
	</form>
</body>
</html>