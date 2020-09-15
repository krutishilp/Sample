<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

User Name:<%=request.getParameter("name") %> <br>
Age:<%=request.getParameter("age") %> <br>
Gender:<%=request.getParameter("gender") %> <br>

</body>
</html>