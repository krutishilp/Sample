<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user" class="com.zensar.model.User">

		<jsp:setProperty property="name" name="user"></jsp:setProperty>
		<jsp:setProperty property="age" name="user"></jsp:setProperty>
		<jsp:setProperty property="gender" name="user"></jsp:setProperty>
		<jsp:setProperty property="*" name="user"></jsp:setProperty>

	</jsp:useBean>

	Name:
	<jsp:getProperty property="name" name="user" /><br> All
	Properties:
	<jsp:getProperty property="userInfo" name="user" />
	
	
	<%-- <jsp:forward page="userDetails.jsp">
		<jsp:param value="Krutishil" name="name"/>
		<jsp:param value="22" name="age"/>
		<jsp:param value="Male" name="gender"/>
	</jsp:forward> --%>

</body>
</html>